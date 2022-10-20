package com.example.demo2.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.demo2.errorCode.ErrorCode;
import com.example.demo2.logger.LoggerService;
import com.example.demo2.response.error4xx.Error400Response;
import com.example.demo2.response.error4xx.Error404Response;
import com.example.demo2.response.error5xx.Error500RuntimeExceptionResponse;

@Configuration
@ControllerAdvice
public class SsafyHandlerAll {

  private final LoggerService loggerService;

  public SsafyHandlerAll(LoggerService loggerService) {
    this.loggerService = loggerService;
  }

  // 400 핸들러
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Error400Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    Error400Response error400Response = Error400Response.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
    loggerService.log(error400Response.toString());
    return new ResponseEntity<>(error400Response, HttpStatus.BAD_REQUEST);
  }

  // 404 핸들러
  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Error404Response> handleNoHandlerFoundException(NoHandlerFoundException e) {
    Error404Response error404Response = Error404Response.of(ErrorCode.NOT_FOUND, e);
    loggerService.log(error404Response.toString());
    return new ResponseEntity<>(error404Response, HttpStatus.NOT_FOUND);
  }

  // 500 RuntimeException 핸들러
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Error500RuntimeExceptionResponse> handleRuntimeException(RuntimeException e) {
    Error500RuntimeExceptionResponse error500RuntimeExceptionResponse = Error500RuntimeExceptionResponse
        .of(ErrorCode.INTERNAL_SERVER_ERROR, e);
    loggerService.log(error500RuntimeExceptionResponse.toString());
    return new ResponseEntity<>(error500RuntimeExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
