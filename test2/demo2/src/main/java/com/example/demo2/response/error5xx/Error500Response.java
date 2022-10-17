package com.example.demo2.response.error5xx;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

import com.example.demo2.errorCode.ErrorCode;

public class Error500Response {

  private String message;
  private int status;
  private List<FieldError> errors;

  public String getMessage() {
    return this.message;
  }

  public int getStatus() {
    return this.status;
  }

  public List<FieldError> getErrors() {
    return this.errors;
  }

  private Error500Response(final ErrorCode code, final List<FieldError> errors) {
    this.message = code.getMessage();
    this.status = code.getStatus();
    this.errors = errors;
  }

  private Error500Response(final ErrorCode code) {
    this.message = code.getMessage();
    this.status = code.getStatus();
  }

  private Error500Response() {
  }

  public static Error500Response of(final ErrorCode code, final BindingResult bindingResult) {
    return new Error500Response(code, FieldError.of(bindingResult));
  }

  public static Error500Response of(final ErrorCode code) {
    return new Error500Response(code);
  }

  public static class FieldError {
    private String field;
    private String value;
    private String message;
    private String objName;

    public String getField() {
      return this.field;
    }

    public String getValue() {
      return this.value;
    }

    public String getMessage() {
      return this.message;
    }

    public String getObjName() {
      return this.objName;
    }

    private FieldError(final String field, final String objName, final String value, final String message) {
      this.field = field;
      this.objName = objName;
      this.value = value;
      this.message = message;
    }

    private static List<FieldError> of(final BindingResult bindingResult) {
      final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
      return fieldErrors.stream()
          .map(error -> new FieldError(
              error.getField(),
              error.getObjectName(),
              String.valueOf(error.getRejectedValue()),
              error.getDefaultMessage()))
          .collect(Collectors.toList());
    }
  }
}