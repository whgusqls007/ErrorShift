package com.ssafy.e206.response.error4xx;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

import com.ssafy.e206.errorCode.ErrorCode;
import com.ssafy.e206.response.ErrorResponse;

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
    private String possibleSolution;

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

    public String getPossibleSolution() {
      return this.possibleSolution;
    }

    @Override
    public String toString() {
      return "{" +
          " field='" + getField() + "'" +
          " value='" + getValue() + "'" +
          " message='" + getMessage() + "'" +
          " objName='" + getObjName() + "'" +
          " possibleSolution='" + getPossibleSolution() + "'" +
          " }";
    }

    private FieldError(final String field, final String objName, final String value, final String message,
        final String possibleSolution) {
      this.field = field;
      this.objName = objName;
      this.value = value;
      this.message = message;
      this.possibleSolution = possibleSolution;
    }

    private static List<FieldError> of(final BindingResult bindingResult) {
      final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
      return fieldErrors.stream()
          .map(error -> new FieldError(
              error.getField(),
              error.getObjectName(),
              String.valueOf(error.getRejectedValue()),
              error.getDefaultMessage(),
              "Your request value is " + error.getRejectedValue() + " for " + error.getField() + " of "
                  + error.getObjectName() + ". You can check the request value and try again."))
          .collect(Collectors.toList());
    }
  }

  @Override
  public String toString() {
    return "{" +
        " message='" + getMessage() + "'" +
        " status='" + getStatus() + "'" +
        " errors='" + getErrors() + "'" +
        " }";
  }
}