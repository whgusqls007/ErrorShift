package com.ssafy.e206.handler;

import com.ssafy.e206.response.ErrorCode;
import com.ssafy.e206.response.HttpMediaTypeNotSupportedExceptionResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Logger;

@Configuration
@ControllerAdvice
public class TestHandler {

//    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
//    public ResponseEntity<HttpMediaTypeNotSupportedExceptionResponse> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
//        HttpMediaTypeNotSupportedExceptionResponse response = HttpMediaTypeNotSupportedExceptionResponse.of(e);
//        return new ResponseEntity<>(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
//    }
}
