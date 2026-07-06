package io.jatinjindal.backend.controller;

import io.jatinjindal.backend.service.CompletionService;
import io.jatinjindal.shared.model.CompletionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CompletionController {

    private final CompletionService completionService;

    @PostMapping(value = "/completions", produces = MediaType.TEXT_PLAIN_VALUE)
    public String streamInlineSuggestions(
            @RequestBody CompletionRequest request
    ) {
        return completionService.getSuggestionChunk(request);
    }
}
