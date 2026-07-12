package io.jatinjindal.backend.model;

import lombok.Getter;

@Getter
public enum ErrorType {
    INVALID_REQUEST_BODY("Invalid Request Body"),
    UNKNOWN_ERROR("Unknown Error"),
    INVALID_MODEL_DETAILS("Invalid Model Details");

    private final String message;
    ErrorType(String message) {
        this.message = message;
    }
}
