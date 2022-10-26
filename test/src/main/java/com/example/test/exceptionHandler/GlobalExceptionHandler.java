package com.example.test.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotation;
import com.ssafy.e206.errorCode.ErrorCode;

@TestAnnotation(exception = NoHandlerFoundException.class, errorCode = ErrorCode.NOT_FOUND, message = "Not Found", status = 404)
@TestAnnotation(exception = NullPointerException.class, errorCode = ErrorCode.INTERNAL_SERVER_ERROR, message = "Internal Server Error", status = 500)
@ControllerAdvice
public class GlobalExceptionHandler {
}