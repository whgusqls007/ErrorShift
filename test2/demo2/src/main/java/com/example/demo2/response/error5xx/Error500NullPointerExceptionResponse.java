package com.example.demo2.response.error5xx;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.example.demo2.errorCode.ErrorCode;

public class Error500NullPointerExceptionResponse {

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

  private Error500NullPointerExceptionResponse(final ErrorCode code, final Map<String, String> errors) {
    this.message = code.getMessage();
    this.status = code.getStatus();
    this.errors = errors;
  }

  private Error500NullPointerExceptionResponse(final ErrorCode code) {
    this.message = code.getMessage();
    this.status = code.getStatus();
  }

  private Error500NullPointerExceptionResponse() {
  }

  public static Error500NullPointerExceptionResponse of(final ErrorCode code, final NullPointerException e) {
    return new Error500NullPointerExceptionResponse(code, FieldError.of(e));
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

    private static Map<String, String> of(final NullPointerException e) {
      StringWriter writer = new StringWriter();
      e.printStackTrace(new PrintWriter(writer));
      String[] errorMsg = writer.getBuffer().toString().split("at")[1].replaceAll(" ", "").replaceAll("\\)",
          "").split("\\(");
      String Location = errorMsg[0];
      String Line = errorMsg[1].replaceAll("\\\r\\\n\\\t", "");

      return new HashMap<String, String>() {
        {
          put("location", Location);
          put("line", Line.split(":")[1]);
          put("errMsg", writer.getBuffer().toString().split("at")[0].replaceAll("\\\r\\\n\\\t", ""));
        }
      };
      
    }

  }
}