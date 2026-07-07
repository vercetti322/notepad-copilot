package io.jatinjindal.backend.service;

import static io.jatinjindal.backend.constant.BackendConstants.*;
import io.jatinjindal.backend.exception.NotepadCopilotBackendException;
import io.jatinjindal.backend.model.CompletionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;

@Service
@RequiredArgsConstructor
public class CompletionService {

    private final ChatClient chatClient;

    public String getSuggestionChunk(CompletionRequest request) {
        // ensure Ollama is running
        boolean ollamaStatus = isOllamaRunning();
        if (!ollamaStatus) { startOllama(); }

        return chatClient.prompt().user(user -> user.text(COMPLETION_PROMPT)
                .param(LANGUAGE, request.language())
                .param(BEFORE_CURSOR, request.beforeCursor())
                .param(AFTER_CURSOR, request.afterCursor())
        ).options(OllamaChatOptions.builder().maxTokens(request.maxTokens())
                .temperature(request.temperature())
        ).call().content();
    }

    private void startOllama() {
        try {
            new ProcessBuilder(OLLAMA_PATH, OLLAMA_SERVE)
                    .redirectErrorStream(true).start();
        } catch (IOException e) {
            throw new NotepadCopilotBackendException(
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
