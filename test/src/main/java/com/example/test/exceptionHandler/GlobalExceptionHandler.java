package com.example.test.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.ErrorShift;

@ErrorShift(exception = NullPointerException.class, message = "Null Pointer Exception", httpStatus = HttpStatus.BAD_REQUEST)
@ErrorShift(exception = ArithmeticException.class, message = "Arithmetic Exception", httpStatus = HttpStatus.NOT_FOUND, language = "ko")
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<String> handle404(NoHandlerFoundException e) {
    return new ResponseEntity<String>("404", HttpStatus.NOT_FOUND);
  }

}
