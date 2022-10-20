package com.example.demo2.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo2.errorCode.ErrorCode;
import com.example.demo2.logger.LoggerService;
import com.example.demo2.response.error4xx.Error400Response;

@Configuration
@ControllerAdvice
public class SsafyHandler400 {

  private final LoggerService loggerService;

  public SsafyHandler400(LoggerService loggerService) {
    this.loggerService = loggerService;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Error400Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    Error400Response error400Response = Error400Response.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
    loggerService.log(error400Response.toString());
    return new ResponseEntity<>(error400Response, HttpStatus.BAD_REQUEST);
  }
}
