package com.example.test.exceptionHandler;

import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotation;

// @EnableSsafyHandler
@TestAnnotation(value = NoHandlerFoundException.class)
public class GlobalExceptionHandler {
}