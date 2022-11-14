package com.example.test.exceptionHandler;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.ErrorShift;

//@ErrorShift(exception = NullPointerException.class, message = "배곺ㅍ팡ㅇㅇㅇ", language = "ko")
@ErrorShift(exception = TypeMismatchException.class, message = "이게 안된다고0", language = "ko")
@ErrorShift(exception = NoHandlerFoundException.class, httpStatus = HttpStatus.INTERNAL_SERVER_ERROR)
@ErrorShift(exception = IllegalArgumentException.class, language = "ko")
@ErrorShift(exception = MethodArgumentNotValidException.class, language = "ko")
@ErrorShift(exception = HttpRequestMethodNotSupportedException.class, language = "ko")
@ErrorShift(exception = HttpMessageNotReadableException.class)
@ErrorShift(exception = HttpMediaTypeNotSupportedException.class, message = "시발", language = "ko")
@ErrorShift(exception = ArithmeticException.class, httpStatus = HttpStatus.BAD_GATEWAY, message = "수문제", language = "ko")
@ErrorShift(exception = ArrayIndexOutOfBoundsException.class, language = "ko")
@ErrorShift(exception = ClassCastException.class, language = "ko")
@ErrorShift(exception = IndexOutOfBoundsException.class, language = "ko")
@ErrorShift(exception = NumberFormatException.class, language = "ko")
@ControllerAdvice
public class GlobalExceptionHandler {
}
