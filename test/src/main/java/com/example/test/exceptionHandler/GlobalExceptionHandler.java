package com.example.test.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.ssafy.e206.annotation.TestAnnotation;

// @TestAnnotation(exception = NullPointerException.class)
// @TestAnnotation(exception = NoHandlerFoundException.class, logging = true, httpStatus = HttpStatus.INTERNAL_SERVER_ERROR)
// @TestAnnotation(exception = ArrayIndexOutOfBoundsException.class, logging = true)
@TestAnnotation(exception = ArithmeticException.class, logging = true, httpStatus = HttpStatus.NOT_FOUND, trace = true)
@ControllerAdvice
public class GlobalExceptionHandler {
}