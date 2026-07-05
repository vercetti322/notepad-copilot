package io.jatinjindal.backend.controller;

import io.jatinjindal.backend.service.CompletionService;
import io.jatinjindal.shared.model.CompletionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CompletionController {

    private final CompletionService completionService;

    @GetMapping(value = "/completions", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamInlineSuggestions(
            @RequestBody CompletionRequest request
    ) {
        return completionService.getSuggestionChunk(request);
    }
}
