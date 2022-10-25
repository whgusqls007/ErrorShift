package com.ssafy.e206.customError;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomError {
  @ExceptionHandler
  public void handleException(Exception err) {
    System.out.println("handleException");
  }
}
