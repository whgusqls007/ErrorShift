package com.example.test.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotation;

<<<<<<< HEAD
@TestAnnotation(exception = NullPointerException.class, httpStatus = HttpStatus.NOT_FOUND, message = "내 메세지")
@TestAnnotation(exception = NoHandlerFoundException.class, httpStatus = HttpStatus.BAD_REQUEST, message = "노핸들러 이지랄")
=======
@TestAnnotation(exception = NullPointerException.class, message = "왜안나오노")
@TestAnnotation(exception = NoHandlerFoundException.class, httpStatus = HttpStatus.INTERNAL_SERVER_ERROR, message = "이건나오나")
@TestAnnotation(exception = IllegalArgumentException.class)
@TestAnnotation(exception = MethodArgumentNotValidException.class)
>>>>>>> d45634bc07a032cbcfe8e8989dcce60fb850d826
@TestAnnotation(exception = HttpRequestMethodNotSupportedException.class)
@TestAnnotation(exception = ArrayIndexOutOfBoundsException.class, httpStatus = HttpStatus.BAD_REQUEST, message = "배열 인덱스 이지랄")
@ControllerAdvice
public class GlobalExceptionHandler {
}