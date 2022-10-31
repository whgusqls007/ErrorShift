package com.ssafy.e206.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.ssafy.e206.configuration.CustomErrorAttributes;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan(basePackages = "com.ssafy.e206.logger")
@Import(CustomErrorAttributes.class)
public @interface TestAnnotations {
  TestAnnotation[] value();
}
