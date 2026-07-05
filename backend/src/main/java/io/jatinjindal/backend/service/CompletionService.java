package io.jatinjindal.backend.service;

import io.jatinjindal.shared.model.CompletionRequest;
import io.swagger.v3.oas.annotations.servers.Server;
import reactor.core.publisher.Flux;

@Server
public class CompletionService {

    public Flux<String> getSuggestionChunk(CompletionRequest request) {

    }
}
