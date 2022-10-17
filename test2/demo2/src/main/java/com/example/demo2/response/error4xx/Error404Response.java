package com.example.demo2.response.error4xx;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.demo2.errorCode.ErrorCode;

public class Error404Response {

  private String message;
  private int status;
  private Map<String, String> errors;

  public String getMessage() {
    return this.message;
  }

  public int getStatus() {
    return this.status;
  }

  public Map<String, String> getErrors() {
    return this.errors;
  }

  private Error404Response(final ErrorCode code, final Map<String, String> map) {
    this.message = code.getMessage();
    this.status = code.getStatus();
    this.errors = map;
  }

  private Error404Response(final ErrorCode code) {
    this.message = code.getMessage();
    this.status = code.getStatus();
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
}