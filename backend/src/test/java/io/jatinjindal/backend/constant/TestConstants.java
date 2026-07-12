package io.jatinjindal.backend.constant;

public class TestConstants {
    private TestConstants() {}
    public static final String TEST_BEFORE_CURSOR = "public void reverse(int[] nums) {\\n";
    public static final String TEST_AFTER_CURSOR = "\\n}";
    public static final String TEST_LANGUAGE = "java";
    public static final String TEST_MODEL = "qwen2.5-coder:1.5b";
    public static final Double TEST_TEMPERATURE = 0.1;
    public static final Integer TEST_MAX_TOKENS = 36;
    public static final String TEST_SUGGESTION = "nums.reverse();";
    public static final String COMPLETIONS_PATH = "/api/completions";
    public static final String TEST_ERROR_RESPONSE = """
            {
                "error": "%s",
                "details": %s
            }
            """;
    public static final String TEST_INVALID_MODEL = "qwen25-code:1.5b";
    public static final String MODEL_NAME_NOT_FOUND = "HTTP 404 - {\"error\":\"model 'qwen25-code:1.5b' not found\"}";
}