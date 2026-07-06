package io.jatinjindal.backend.config;

import io.jatinjindal.backend.constant.BackendConstants;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    ChatClient completionChatClient(ChatClient.Builder clientBuilder) {
        return clientBuilder.defaultSystem(BackendConstants
                .SYSTEM_PROMPT).build();
    }
}
