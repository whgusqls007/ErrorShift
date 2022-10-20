package com.example.demo2.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo2.errorCode.ErrorCode;
import com.example.demo2.logger.LoggerService;
import com.example.demo2.response.error5xx.Error500RuntimeExceptionResponse;

@Configuration
@ControllerAdvice
public class SsafyHandler500 {

  // @Autowired
  // private LoggerService loggerService;

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Error500RuntimeExceptionResponse> hadleNullPointerException(RuntimeException e) {
    Error500RuntimeExceptionResponse error500RuntimeExceptionResponse = Error500RuntimeExceptionResponse
        .of(ErrorCode.INTERNAL_SERVER_ERROR, e);
    // loggerService.log(error500NullPointerExceptionResponse.toString());
    return new ResponseEntity<>(error500RuntimeExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
