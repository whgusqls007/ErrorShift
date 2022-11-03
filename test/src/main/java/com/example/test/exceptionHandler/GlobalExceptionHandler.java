package com.example.test.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotation;

@TestAnnotation(exception = NullPointerException.class, httpStatus = HttpStatus.NOT_FOUND, message = "내 메세지")
@TestAnnotation(exception = NoHandlerFoundException.class, httpStatus = HttpStatus.BAD_REQUEST, message = "노핸들러 이지랄")
@TestAnnotation(exception = HttpRequestMethodNotSupportedException.class)
@TestAnnotation(exception = ArrayIndexOutOfBoundsException.class, httpStatus = HttpStatus.BAD_REQUEST, message = "배열 인덱스 이지랄")
@ControllerAdvice
public class GlobalExceptionHandler {
}