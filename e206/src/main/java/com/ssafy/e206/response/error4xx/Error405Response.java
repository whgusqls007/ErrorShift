package com.ssafy.e206.response.error4xx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.ssafy.e206.errorCode.ErrorCode;
import com.ssafy.e206.response.ErrorResponse;

public class Error405Response extends ErrorResponse {
  private Map<String, String> errors;

  public Map<String, String> getErrors() {
    return this.errors;
  }

  private Error405Response(final ErrorCode code, final Map<String, String> map) {
    super(code.getMessage(), code.getStatus());
    this.errors = map;
  }

  private Error405Response() {
  }

  public static Error405Response of(final ErrorCode code, final HttpRequestMethodNotSupportedException e) {
    return new Error405Response(code, FieldError.of(e));
  }

  public static class FieldError {
    private String message;
    private String requestedMethod;
    private String supportedMethod;

    public String getRequestURL() {
      return this.message;
    }

    public String getMethod() {
      return this.requestedMethod;
    }

    public String getSupportedMethod() {
      return this.supportedMethod;
    }

    private FieldError(final String message, final String requestedMethod, final String supportedMethod) {
      this.message = message;
      this.requestedMethod = requestedMethod;
      this.supportedMethod = supportedMethod;
    }

    private static Map<String, String> of(final HttpRequestMethodNotSupportedException e) {
      return new HashMap<String, String>() {
        {
          put("message", e.getMessage());
          put("requestedMethod", e.getMethod());
          put("supportedMethod", Arrays.toString(e.getSupportedMethods()));
        }
      };
    }
  }

  @Override
  public String toString() {
    return "{" +
        " message='" + getMessage() + "'" +
        ", status='" + getStatus() + "'" +
        ", errors='" + getErrors() + "'" +
        "}";
  }
}
