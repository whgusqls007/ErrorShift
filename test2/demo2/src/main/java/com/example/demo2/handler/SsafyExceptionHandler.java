package com.example.demo2.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.demo2.response.error4xx.Error400Response;
import com.example.demo2.response.error4xx.Error404Response;
import com.example.demo2.response.error5xx.Error500NullPointerExceptionResponse;

public interface SsafyExceptionHandler {
  // 400
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Error400Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException e);

  // 404
  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Error404Response> handleNoHandlerFoundException(NoHandlerFoundException e);

  // 500 NullPointerException
  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<Error500NullPointerExceptionResponse> hadleNullPointerException(NullPointerException e);
}
