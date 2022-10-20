package com.example.demo2.response.error4xx;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

import com.example.demo2.errorCode.ErrorCode;
import com.example.demo2.response.ErrorResponse;

public class Error400Response extends ErrorResponse {
  private List<FieldError> errors;

  public List<FieldError> getErrors() {
    return this.errors;
  }

  private Error400Response(final ErrorCode code, final List<FieldError> errors) {
    super(code.getMessage(), code.getStatus());
    this.errors = errors;
  }

  private Error400Response() {
  }

  public static Error400Response of(final ErrorCode code, final BindingResult bindingResult) {
    return new Error400Response(code, FieldError.of(bindingResult));
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

  @Override
  public String toString() {
    return "{" +
        " message='" + getMessage() + "'" +
        ", status='" + getStatus() + "'" +
        ", errors='" + getErrors() + "'" +
        "}";
  }
}