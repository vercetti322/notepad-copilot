package io.jatinjindal.backend.constant;

import java.net.URI;

public class BackendConstants {
    private BackendConstants() {}
    public static final String BEFORE_CURSOR = "beforeCursor";
    public static final String AFTER_CURSOR = "afterCursor";
    public static final String LANGUAGE = "language";
    public static final String ERROR = "[ERROR] ";
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
    // to be replaced later -- start
    public static final URI OLLAMA_HOST = URI.create("http://localhost:11434/api/tags");
    public static final String OLLAMA_PATH = "\"C:\\Users\\HP\\AppData\\Local\\Programs\\Ollama\\ollama.exe\"";
    public static final String OLLAMA_SERVE = "serve";
    // to be replaced later -- end
    public static final Integer CONNECTION_TIMEOUT = 5000;
    public static final Integer READ_TIMEOUT = 2000;
    public static final String OLLAMA_FAILED_TO_START = ERROR + "Failed to start the OLLAMA engine.";
}
