package io.jatinjindal.backend.service;

import io.jatinjindal.backend.constant.BackendConstants;
import io.jatinjindal.backend.model.CompletionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompletionService {

    private final ChatClient chatClient;

    public String getSuggestionChunk(CompletionRequest request) {
        return chatClient.prompt().user(user ->
                user.text(BackendConstants.COMPLETION_PROMPT)
                        .param(BackendConstants.LANGUAGE, request.language())
                        .param(BackendConstants.BEFORE_CURSOR, request.beforeCursor())
                        .param(BackendConstants.AFTER_CURSOR, request.afterCursor())
        ).options(OllamaChatOptions.builder().maxTokens(request.maxTokens())
                .temperature(request.temperature())
        ).call().content();
    }
}
