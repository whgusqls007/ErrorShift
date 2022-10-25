package com.ssafy.e206.errorCode;

public enum ErrorCode {
  INVALID_INPUT_VALUE(400, "Invalid Input Value"),
  ENTITY_NOT_FOUND(400, "Entity Not Found"),
  INVALID_JWT_TOKEN(401, "Invalid JWT Token"),
  EXPIRED_JWT_TOKEN(401, "Expired JWT Token"),
  ACCESS_DENIED(401, "Access Denied"),
  METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
  INTERNAL_SERVER_ERROR(500, "Server Error"),
  HANDLE_ACCESS_DENIED(403, "Access is Denied"),
  NOT_FOUND(404, "Not Found"),
  REQUEST_URI_TOO_LONG(414, "Request URI Too Long"),
  NULL_POINRTER(6000, "널이지롱");

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