package com.example.demo.exceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Component
public class ErrorResponse2 {

  private String message;
  private int status;
  private List<FieldError> errors;

  private ErrorResponse2(final ErrorCode2 code, final List<FieldError> errors) {
    this.message = code.getMessage();
    this.status = code.getStatus();
    this.errors = errors;
  }

  private ErrorResponse2(final ErrorCode2 code) {
    this.message = code.getMessage();
    this.status = code.getStatus();
  }

  public static ErrorResponse2 of(final ErrorCode2 code, final BindingResult bindingResult) {
    return new ErrorResponse2(code, FieldError.of(bindingResult));
  }

  public static ErrorResponse2 of(final ErrorCode2 code) {
    return new ErrorResponse2(code);
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class FieldError {
    private String field;
    private String value;
    private String message;
    private String objName;

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