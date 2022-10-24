package com.ssafy.e206.errorCode;

public enum ErrorCode {
  INVALID_INPUT_VALUE(400, "Invalid Input Value"),
  NOT_FOUND(404, "Not Found"),
  METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
  REQUEST_URI_TOO_LONG(414, "Request URI Too Long"),
  INTERNAL_SERVER_ERROR(500, "Internal Server Error");

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