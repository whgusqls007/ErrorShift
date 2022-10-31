package com.example.test.exceptionHandler;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotation;

@TestAnnotation(exception = NullPointerException.class)
@TestAnnotation(exception = NoHandlerFoundException.class)
@TestAnnotation(exception = IllegalArgumentException.class)
@TestAnnotation(exception = MethodArgumentNotValidException.class)
@TestAnnotation(exception = HttpRequestMethodNotSupportedException.class)
@TestAnnotation(exception = BindException.class)
@TestAnnotation(exception = HttpMessageNotReadableException.class)
@ControllerAdvice
public class GlobalExceptionHandler {
}