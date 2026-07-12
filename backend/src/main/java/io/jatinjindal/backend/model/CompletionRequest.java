package io.jatinjindal.backend.model;

import jakarta.validation.constraints.*;
import lombok.Builder;
import static io.jatinjindal.backend.constant.BackendConstants.*;

@Builder
public record CompletionRequest(
    @NotBlank(message = BEFORE_CURSOR_NOT_BLANK)
    String beforeCursor,

    @NotNull(message = AFTER_CURSOR_REQUIRED)
    String afterCursor,

    @NotBlank(message = LANGUAGE_REQUIRED)
    String language,

    @NotBlank(message = MODEL_NOT_BLANK)
    String model,

    @NotNull(message = TEMPERATURE_REQUIRED)
    @DecimalMin(value = "0.0", message = TEMPERATURE_RANGE)
    @DecimalMax(value = "1.0", message = TEMPERATURE_RANGE)
    Double temperature,

    @NotNull(message = MAX_TOKENS_REQUIRED)
    @Min(value = 8, message = MAX_TOKENS_MIN)
    @Max(value = 64, message = MAX_TOKENS_MAX)
    Integer maxTokens
) { }
