package com.example.demo2.response.error4xx;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.demo2.errorCode.ErrorCode;
import com.example.demo2.response.ErrorResponse;

public class Error404Response extends ErrorResponse {
  private Map<String, String> errors;

  public Map<String, String> getErrors() {
    return this.errors;
  }

  private Error404Response(final ErrorCode code, final Map<String, String> map) {
    super(code.getMessage(), code.getStatus());
    this.errors = map;
  }

  private Error404Response() {
  }

  public static Error404Response of(final ErrorCode code, final NoHandlerFoundException e) {
    return new Error404Response(code, FieldError.of(e));
  }

  public static class FieldError {
    private String requestURL;
    private String method;

    public String getRequestURL() {
      return this.requestURL;
    }

    public String getMethod() {
      return this.method;
    }

    private FieldError(final String requestURL, final String method) {
      this.requestURL = requestURL;
      this.method = method;
    }

    private static Map<String, String> of(final NoHandlerFoundException e) {
      return new HashMap<String, String>() {
        {
          put("requestURL", e.getRequestURL());
          put("method", e.getHttpMethod());
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