package io.jatinjindal.shared.model;

public record CompletionRequest(
    String beforeCursor,
    String afterCursor,
    String language,
    Integer maxTokens
) { }
