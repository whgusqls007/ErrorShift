package com.ssafy.e206.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.ssafy.e206.configuration.CustomErrorAttributes;

@Repeatable(TestAnnotations.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan(basePackages = "com.ssafy.e206.logger")
@Import(CustomErrorAttributes.class)
public @interface TestAnnotation {
  String[] value() default {};

  String message()

  default "";

  Class<? extends Throwable> exception();

  boolean field() default false;

  boolean objName() default false;

  boolean param() default false;

  boolean errMessage() default false;

  boolean requestURL() default false;

  boolean method() default false;

  boolean requestedMethod() default false;

  boolean supportedMethod() default false;
}