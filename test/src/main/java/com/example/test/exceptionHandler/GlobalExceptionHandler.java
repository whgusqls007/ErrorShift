package com.example.test.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotation;

@TestAnnotation(exception = NullPointerException.class, message = "왜안나오노")
@TestAnnotation(exception = NoHandlerFoundException.class, httpStatus = HttpStatus.INTERNAL_SERVER_ERROR, message = "이건나오나")
@TestAnnotation(exception = IllegalArgumentException.class)
@TestAnnotation(exception = MethodArgumentNotValidException.class)
@TestAnnotation(exception = HttpRequestMethodNotSupportedException.class)
@TestAnnotation(exception = HttpMessageNotReadableException.class)
@ControllerAdvice
public class GlobalExceptionHandler {
}