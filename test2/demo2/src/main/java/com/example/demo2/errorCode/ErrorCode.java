package com.example.demo2.errorCode;

public enum ErrorCode {
  INVALID_INPUT_VALUE(400, "Invalid Input Value"),
  NOT_FOUND(404, "Not Found");

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