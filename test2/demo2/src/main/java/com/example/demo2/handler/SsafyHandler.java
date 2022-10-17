package com.example.demo2.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.demo2.errorCode.ErrorCode;
import com.example.demo2.response.error4xx.Error400Response;
import com.example.demo2.response.error4xx.Error404Response;

@ControllerAdvice
@Component
public class SsafyHandler implements SsafyExceptionHandler {

  // 400 핸들러
  @Override
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Error400Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    return new ResponseEntity<>(Error400Response.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult()),
        HttpStatus.BAD_REQUEST);
  }

  // 404 핸들러
  @Override
  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Error404Response> handleNoHandlerFoundException(NoHandlerFoundException e) {
    return new ResponseEntity<>(Error404Response.of(ErrorCode.NOT_FOUND, e),
        HttpStatus.NOT_FOUND);
  }

}
