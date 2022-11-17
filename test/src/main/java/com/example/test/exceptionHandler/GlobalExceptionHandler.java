package com.example.test.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.ssafy.e206.annotation.ErrorShift;

@ErrorShift(exception = NullPointerException.class, message = "Null Pointer Exception", httpStatus = HttpStatus.BAD_REQUEST)
@ErrorShift(exception = ArithmeticException.class, message = "Arithmetic Exception", httpStatus = HttpStatus.NOT_FOUND, language = "ko")
@ControllerAdvice
public class GlobalExceptionHandler {
}
