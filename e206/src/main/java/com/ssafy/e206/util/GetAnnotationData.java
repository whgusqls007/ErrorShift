package com.ssafy.e206.util;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import com.ssafy.e206.annotation.ErrorShift;
import com.ssafy.e206.annotation.ErrorShifts;

@SuppressWarnings("null")
public class GetAnnotationData {

  public static AnnotationAttributes[] getAnnotations(AnnotationMetadata importMetadata) {
    try {
      return AnnotationAttributes
          .fromMap(importMetadata.getAnnotationAttributes(ErrorShifts.class.getName()))
          .getAnnotationArray("value");
    } catch (Exception e) {
      return null;
    }
  }

  public static AnnotationAttributes getAnnotation(AnnotationMetadata importMetadata) {
    try {
      return AnnotationAttributes
          .fromMap(importMetadata.getAnnotationAttributes(ErrorShift.class.getName()));
    } catch (Exception e) {
      return null;
    }
  }

}
