package com.ssafy.e206.util;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import com.ssafy.e206.annotation.TestAnnotation;
import com.ssafy.e206.annotation.TestAnnotations;

@SuppressWarnings("null")
public class GetAnnotationData {

  public static AnnotationAttributes[] getAnnotations(AnnotationMetadata importMetadata) {
    try {
      return AnnotationAttributes
          .fromMap(importMetadata.getAnnotationAttributes(TestAnnotations.class.getName()))
          .getAnnotationArray("value");
    } catch (Exception e) {
      return null;
    }
  }

  public static AnnotationAttributes getAnnotation(AnnotationMetadata importMetadata) {
    try {
      return AnnotationAttributes
          .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()));
    } catch (Exception e) {
      return null;
    }
  }

}
