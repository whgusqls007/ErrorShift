package com.ssafy.e206.configuration;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.ssafy.e206.annotation.TestAnnotation;

@SuppressWarnings("null")
@ControllerAdvice
public class TestAnnotationSelector implements ImportSelector {

  private Class<? extends Throwable> getExceptionClass(AnnotationMetadata importingClassMetadata) {
    return AnnotationAttributes
        .fromMap(importingClassMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getClass("value");
  }

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    Class<? extends Throwable> err = getExceptionClass(importingClassMetadata);
    return new String[] {};
  }
}
