package com.ssafy.e206.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.errorCode.ErrorCode;
import com.ssafy.e206.logger.LoggerService;
import com.ssafy.e206.response.error4xx.Error404Response;

@Configuration
@ControllerAdvice
public class SsafyHandler404 {

  private final LoggerService loggerService;

  public SsafyHandler404(LoggerService loggerService) {
    this.loggerService = loggerService;
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Error404Response> handleNoHandlerFoundException(NoHandlerFoundException e) {
    Error404Response error404Response = Error404Response.of(ErrorCode.NOT_FOUND, e);
    loggerService.log("\n" + error404Response.toString());
    return new ResponseEntity<>(error404Response, HttpStatus.NOT_FOUND);
  }
}
