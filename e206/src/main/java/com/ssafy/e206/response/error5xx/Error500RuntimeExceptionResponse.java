package com.ssafy.e206.response.error5xx;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class Error500RuntimeExceptionResponse {
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

  private Error500RuntimeExceptionResponse(final HttpStatus code, final Map<String, String> errors) {
    this.message = code.name();
    this.status = code.value();
    this.errors = errors;
  }

  private Error500RuntimeExceptionResponse(final HttpStatus code) {
    this.message = code.name();
    this.status = code.value();
  }

  private Error500RuntimeExceptionResponse() {
  }

  public static Error500RuntimeExceptionResponse of(final HttpStatus code, final Exception e) {
    return new Error500RuntimeExceptionResponse(code, FieldError.of((RuntimeException) e));
  }

  @Override
  public String toString() {
    return "{" +
        " message='" + getMessage() + "'" +
        ", status='" + getStatus() + "'" +
        ", errors='" + getErrors() + "'" +
        "}";
  }

  public static class FieldError {
    private String errMsg;
    private String location;
    private String line;

    public String errMsg() {
      return this.errMsg;
    }

    public String getLocation() {
      return this.location;
    }

    public String getLine() {
      return this.line;
    }

    private FieldError(final String location, final String line, final String errMsg) {
      this.location = location;
      this.line = line;
      this.errMsg = errMsg;
    }

    private static Map<String, String> of(final RuntimeException e) {
      StringWriter writer = new StringWriter();
      e.printStackTrace(new PrintWriter(writer));
      String[] errorMsg = writer.getBuffer().toString().split("at")[1].replaceAll(" ", "").replaceAll("\\)",
          "").split("\\(");
      String errMsg = writer.getBuffer().toString().split("at")[0].replaceAll("\\\r\\\n\\\t", "");
      String Location = errorMsg[0];
      String Line = errorMsg[1].replaceAll("\\\r\\\n\\\t", "");

      return new HashMap<String, String>() {
        {
          put("location", Location);
          put("line", Line.split(":")[1]);
          put("errMsg", errMsg);
          put("possibleSolution", "Your error is occurred in " + Location + " at line "
              + Line.split(":")[1]
              + ". You can check the error and try again.");
        }
      };
    }
  }
}
