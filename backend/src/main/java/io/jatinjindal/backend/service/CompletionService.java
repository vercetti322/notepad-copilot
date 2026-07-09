package io.jatinjindal.backend.service;

import static io.jatinjindal.backend.constant.BackendConstants.*;
import io.jatinjindal.backend.exception.NotepadCopilotException;
import io.jatinjindal.backend.model.CompletionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CompletionService {

    private final ChatClient chatClient;

    public String getSuggestionChunk(CompletionRequest request) {
        boolean ollamaStatus = isOllamaRunning();
        if (!ollamaStatus) { startOllama(); }

        String response = chatClient.prompt().user(
                user -> user.text(COMPLETION_PROMPT)
                        .param(LANGUAGE, request.language())
                        .param(BEFORE_CURSOR, request.beforeCursor())
                        .param(AFTER_CURSOR, request.afterCursor())
        ).options(OllamaChatOptions.builder().maxTokens(request.maxTokens())
                .temperature(request.temperature()).model(request.model())
        ).call().content();

        System.out.println(response);
        return sanitize(Objects.requireNonNull(response),
                request.beforeCursor(), request.afterCursor()
        );
    }

    private String sanitize(String response, String beforeCursor, String afterCursor) {
        if (response.isBlank()) { return ""; }

        // remove Markdown back-ticks
        String raw = response.strip().replaceFirst("^```\\w*\\R?", "")
                .replaceFirst("\\R?```$", "").strip();

        // remove text before/after the cursor
        return removeOverlap(raw, beforeCursor, afterCursor);
    }

    private String removeOverlap(String raw, String beforeCursor, String afterCursor) {
        int beforeOverlap = Math.min(beforeCursor.length(), raw.length());
        for (int overlap = beforeOverlap; overlap > 0; overlap--) {
            if (beforeCursor.endsWith(raw.substring(0, overlap))) {
                raw = raw.substring(overlap); break;
            }
        }

        int afterOverlap = Math.min(afterCursor.length(), raw.length());
        for (int overlap = afterOverlap; overlap > 0; overlap--) {
            if (afterCursor.startsWith(raw.substring(raw.length() - overlap))) {
                raw = raw.substring(0, raw.length() - overlap); break;
            }
        }

        return raw;
    }

    private void startOllama() {
        try {
            new ProcessBuilder(OLLAMA_PATH, OLLAMA_SERVE)
                    .redirectErrorStream(true).start();
        } catch (IOException e) {
            throw new NotepadCopilotException(
                    OLLAMA_FAILED_TO_START, e
            );
        }
    }

    private boolean isOllamaRunning() {
        try {
            HttpURLConnection connection = (HttpURLConnection) OLLAMA_HOST
                    .toURL().openConnection();

            connection.setConnectTimeout(CONNECTION_TIMEOUT);
            connection.setReadTimeout(READ_TIMEOUT);

            return connection.getResponseCode() == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            return false;
        }
    }
}
