package com.example.test.exceptionHandler;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotation;

//@TestAnnotation(exception = NullPointerException.class, message = "안녕 ! ^^", trace = true)
//@TestAnnotation(exception = NullPointerException.class, message = "배곺ㅍ팡ㅇㅇㅇ", language = "ko")
@TestAnnotation(exception = TypeMismatchException.class, language = "ko", message = "타입미스매치")
@TestAnnotation(exception = NullPointerException.class, message = "배곺ㅍ팡ㅇㅇㅇ")
@TestAnnotation(exception = TypeMismatchException.class, message = "이게 안된다고0", language = "ko")
@TestAnnotation(exception = NoHandlerFoundException.class, httpStatus = HttpStatus.INTERNAL_SERVER_ERROR)
@TestAnnotation(exception = IllegalArgumentException.class, language = "ko")
@TestAnnotation(exception = MethodArgumentNotValidException.class, language = "ko")
@TestAnnotation(exception = HttpRequestMethodNotSupportedException.class, language = "ko")
@TestAnnotation(exception = HttpMessageNotReadableException.class)
@TestAnnotation(exception = HttpMediaTypeNotSupportedException.class, message = "시발", language = "ko")
@TestAnnotation(exception = ArithmeticException.class, httpStatus = HttpStatus.BAD_GATEWAY, message = "수문제", language = "ko")
@TestAnnotation(exception = ArrayIndexOutOfBoundsException.class, language = "ko")
@TestAnnotation(exception = ClassCastException.class, language = "ko")
@TestAnnotation(exception = IndexOutOfBoundsException.class, language = "ko")
@TestAnnotation(exception = NumberFormatException.class, language = "ko")
@ControllerAdvice
public class GlobalExceptionHandler {
}
