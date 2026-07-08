package io.jatinjindal.backend.constant;

import java.net.URI;

public class BackendConstants {
    private BackendConstants() {}
    public static final String BEFORE_CURSOR = "beforeCursor";
    public static final String AFTER_CURSOR = "afterCursor";
    public static final String LANGUAGE = "language";
    public static final String ERROR = "[ERROR] ";
    public static final String SYSTEM_PROMPT = """
        You are an inline code completion engine.
        
        Your job is to generate the text that should be inserted at the cursor.
        
        Rules:
        - Return only the text to insert.
        - Do not repeat text before the cursor.
        - Do not repeat text after the cursor.
        - Do not explain.
        - Do not use Markdown.
        - Preserve the coding style, indentation, and formatting.
        - If no completion is appropriate, return an empty response.
        """;
    public static final String COMPLETION_PROMPT = """
        Complete the following code.

        Language: {language}

        <PRECEDING_CODE>
        {beforeCursor}
        </PRECEDING_CODE>

        <CURSOR>

        <FOLLOWING_CODE>
        {afterCursor}
        </FOLLOWING_CODE>

        Return only the code that belongs at <CURSOR>.
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
