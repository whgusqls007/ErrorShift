package com.example.test.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotation;
import com.ssafy.e206.errorCode.ErrorCode;

@TestAnnotation(exception = NoHandlerFoundException.class, errorCode = HttpStatus.NOT_FOUND, message = "Not Found")
@TestAnnotation(exception = NullPointerException.class, errorCode = HttpStatus.INTERNAL_SERVER_ERROR, message = "Internal Server Error")
@ControllerAdvice
public class GlobalExceptionHandler {
}