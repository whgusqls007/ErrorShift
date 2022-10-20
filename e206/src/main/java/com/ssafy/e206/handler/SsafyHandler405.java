package com.ssafy.e206.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ssafy.e206.errorCode.ErrorCode;
import com.ssafy.e206.logger.LoggerService;
import com.ssafy.e206.response.error4xx.Error405Response;

@Configuration
@ControllerAdvice
public class SsafyHandler405 {
  private final LoggerService loggerService;

  public SsafyHandler405(LoggerService loggerService) {
    this.loggerService = loggerService;
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<Error405Response> handleNoHandlerFoundException(HttpRequestMethodNotSupportedException e) {
    Error405Response error405Response = Error405Response.of(ErrorCode.METHOD_NOT_ALLOWED, e);
    loggerService.log(error405Response.toString());
    return new ResponseEntity<>(error405Response, HttpStatus.METHOD_NOT_ALLOWED);
  }
}
