package com.example.test.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotation;

@TestAnnotation(exception = NoHandlerFoundException.class, errorCode = HttpStatus.NOT_FOUND, basePackage = "com.example.test.exceptionHandler.Error404Response")
@TestAnnotation(exception = NullPointerException.class, errorCode = HttpStatus.INTERNAL_SERVER_ERROR)
@ControllerAdvice
public class GlobalExceptionHandler {
}