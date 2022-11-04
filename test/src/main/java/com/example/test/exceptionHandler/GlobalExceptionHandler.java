package com.example.test.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotation;

@TestAnnotation(exception = NullPointerException.class, httpStatus = HttpStatus.BAD_REQUEST, message = "내 메세지", trace = false)
@TestAnnotation(exception = NoHandlerFoundException.class, httpStatus = HttpStatus.BAD_REQUEST, message = "노핸들러 이지랄")
// @TestAnnotation(exception = IllegalArgumentException.class)
// @TestAnnotation(exception = MethodArgumentNotValidException.class)
// @TestAnnotation(exception = HttpRequestMethodNotSupportedException.class)
// @TestAnnotation(exception = ArrayIndexOutOfBoundsException.class, httpStatus
// = HttpStatus.BAD_REQUEST, message = "배열 인덱스 이지랄")
// @TestAnnotation(exception = IndexOutOfBoundsException.class)
// @ControllerAdvice
public class GlobalExceptionHandler {
}