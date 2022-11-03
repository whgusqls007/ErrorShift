package com.example.test.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotation;

import java.net.BindException;

@TestAnnotation(exception = NullPointerException.class, message = "안녕 ! ^^")
@TestAnnotation(exception = NoHandlerFoundException.class, httpStatus = HttpStatus.INTERNAL_SERVER_ERROR)
@TestAnnotation(exception = IllegalArgumentException.class)
@TestAnnotation(exception = MethodArgumentNotValidException.class)
@TestAnnotation(exception = HttpRequestMethodNotSupportedException.class)
@TestAnnotation(exception = HttpMessageNotReadableException.class)
@TestAnnotation(exception = HttpMediaTypeNotSupportedException.class, httpStatus = HttpStatus.UNSUPPORTED_MEDIA_TYPE, message = "error morgetta")
@TestAnnotation(exception = ArithmeticException.class, httpStatus = HttpStatus.INTERNAL_SERVER_ERROR, message = "수문제")
@ControllerAdvice
public class GlobalExceptionHandler {
}