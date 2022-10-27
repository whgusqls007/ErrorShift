package com.ssafy.e206.annotation;

import java.lang.annotation.Repeatable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Repeatable(TestAnnotations.class)
@ControllerAdvice
public @interface TestAnnotation {
  Class<? extends Throwable> exception();

  HttpStatus errorCode() default HttpStatus.OK;

  String basePackage() default "";
}