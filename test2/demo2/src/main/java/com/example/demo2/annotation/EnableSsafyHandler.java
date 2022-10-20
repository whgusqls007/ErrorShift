package com.example.demo2.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.example.demo2.configuration.EnableSsafyHandlerSelector;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(EnableSsafyHandlerSelector.class)
@ControllerAdvice
@ComponentScan(basePackages = "com.example.demo2.logger")
public @interface EnableSsafyHandler {
  String[] value() default {};
}