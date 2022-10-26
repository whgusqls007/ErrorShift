package com.ssafy.e206.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.ssafy.e206.configuration.TestAnnotationSelector;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan(basePackages = "com.ssafy.e206.logger")
@Import(TestAnnotationSelector.class)
@ControllerAdvice
public @interface TestAnnotations {
  TestAnnotation[] value();
}
