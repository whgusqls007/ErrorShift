package com.ssafy.e206.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.ssafy.e206.configuration.CustomErrorAttributes;
import com.ssafy.e206.controller.CustomErrorController;

@Repeatable(ErrorShifts.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({ CustomErrorAttributes.class, CustomErrorController.class })
@ControllerAdvice
public @interface ErrorShift {
  String message() default "";

  String userResPackage() default "";

  Class<? extends Throwable> exception();

  boolean logging() default false;

  boolean prettyRes() default true;

  boolean trace() default false;

  HttpStatus httpStatus() default HttpStatus.INTERNAL_SERVER_ERROR;

  String language() default "en"; // en ko
}