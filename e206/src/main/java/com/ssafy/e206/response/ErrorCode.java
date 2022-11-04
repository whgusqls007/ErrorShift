package com.ssafy.e206.response;

public enum ErrorCode {
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type ! ~ ");

    private final int status;
    private final String message;
    ErrorCode(final int status, final String message) {
        this.status = status;
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
    public int getStatus() {
        return this.status;
    }
}
