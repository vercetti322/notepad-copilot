package io.jatinjindal.backend.model;

import lombok.Builder;
import java.time.Instant;
import java.util.List;

@Builder
public record ErrorResponse(
        Instant timestamp,
        String error,
        List<String> details
) { }
