package com.example.demo2.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.demo2.errorCode.ErrorCode;
import com.example.demo2.logger.LoggerService;
import com.example.demo2.response.error4xx.Error404Response;

@Configuration
@ControllerAdvice
public class SsafyHandler404 {

  // @Autowired
  // private LoggerService loggerService;

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Error404Response> handleNoHandlerFoundException(NoHandlerFoundException e) {
    Error404Response error404Response = Error404Response.of(ErrorCode.NOT_FOUND, e);
    // loggerService.log(error404Response.toString());
    return new ResponseEntity<>(error404Response, HttpStatus.NOT_FOUND);
  }
}
