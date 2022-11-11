package com.example.test.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotation;

//@TestAnnotation(exception = NullPointerException.class, message = "안녕 ! ^^", trace = true)
//@TestAnnotation(exception = NullPointerException.class, message = "배곺ㅍ팡ㅇㅇㅇ", language = "ko")
@TestAnnotation(exception = NullPointerException.class, message = "배곺ㅍ팡ㅇㅇㅇ")
@TestAnnotation(exception = NoHandlerFoundException.class, httpStatus = HttpStatus.INTERNAL_SERVER_ERROR)
@TestAnnotation(exception = IllegalArgumentException.class)
@TestAnnotation(exception = MethodArgumentNotValidException.class)
@TestAnnotation(exception = HttpRequestMethodNotSupportedException.class)
@TestAnnotation(exception = HttpMessageNotReadableException.class)
@TestAnnotation(exception = HttpMediaTypeNotSupportedException.class, message = "시발", language = "ko")
@TestAnnotation(exception = ArithmeticException.class, httpStatus = HttpStatus.BAD_GATEWAY, message = "수문제", trace = true)
@ControllerAdvice
public class GlobalExceptionHandler {
}
