package com.example.demo.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;

import com.example.demo2.handler.SsafyHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends SsafyHandler {

}