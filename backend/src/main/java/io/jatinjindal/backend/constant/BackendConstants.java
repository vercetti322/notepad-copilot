package io.jatinjindal.backend.constant;

public class BackendConstants {
    private BackendConstants() {}
    public static final String BEFORE_CURSOR = "beforeCursor";
    public static final String AFTER_CURSOR = "afterCursor";
    public static final String LANGUAGE = "language";
    public static final String SYSTEM_PROMPT = """
            You are a code completion engine.
            Return only the missing code at the cursor.

            Rules:
            - Return only code.
            - Do NOT explain.
            - Do NOT use markdown.
            - Do NOT repeat the existing code.
            - Preserve the existing style and indentation.
    """;
    public static final String COMPLETION_PROMPT = """
            Language: {language}

            Text before cursor:
            {beforeCursor}

            Text after cursor:
            {afterCursor}

            Complete the and return ONLY the missing code.
    """;
}
