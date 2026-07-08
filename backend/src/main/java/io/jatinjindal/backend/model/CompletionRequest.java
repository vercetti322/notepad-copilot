package io.jatinjindal.backend.model;

import jakarta.validation.constraints.*;

public record CompletionRequest(
    @NotNull(message = "Text before the cursor cannot be null")
    String beforeCursor,

    @NotNull(message = "Text after the cursor cannot be null")
    String afterCursor,

    @NotBlank(message = "Language cannot be blank")
    String language,

    @NotBlank(message = "model cannot be blank")
    String model,

    @NotNull(message = "Temperature cannot be null")
    @DecimalMin("0.0") @DecimalMax("1.0") Double temperature,

    @NotNull(message = "Max tokens cannot be null")
    @Min(8) @Max(64) Integer maxTokens
) { }
