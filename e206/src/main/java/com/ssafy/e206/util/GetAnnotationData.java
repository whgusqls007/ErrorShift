package com.ssafy.e206.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.http.HttpStatus;

import com.ssafy.e206.annotation.TestAnnotation;
import com.ssafy.e206.annotation.TestAnnotations;

@SuppressWarnings("null")
public class GetAnnotationData {

  public static AnnotationAttributes[] getAnnotations(AnnotationMetadata importMetadata) {
    try {
      return AnnotationAttributes
          .fromMap(importMetadata.getAnnotationAttributes(TestAnnotations.class.getName()))
          .getAnnotationArray("value");
    } catch (NullPointerException e) {
      return null;
    }
  }

  public static Class<? extends Throwable> getExceptionClass(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getClass("exception");
  }

  public static String[] getValue(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getStringArray("value");
  }

  public static String getMessage(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getString("message");
  }

  public static boolean getField(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getBoolean("field");
  }

  public static boolean getObjName(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getBoolean("objName");
  }

  public static boolean getParam(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getBoolean("param");
  }

  public static boolean getErrMessage(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getBoolean("errMessage");
  }

  public static boolean getRequestURL(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getBoolean("requestURL");
  }

  public static boolean getMethod(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getBoolean("method");
  }

  public static boolean getRequestedMethod(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getBoolean("requestedMethod");
  }

  public static boolean getSupportedMethod(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getBoolean("supportedMethod");
  }

  public static Object getStackTrace(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getBoolean("trace");
  }

  public static boolean getUseCustomResponse(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getBoolean("prettyRes");
  }

  public static HttpStatus getHttpStatus(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getEnum("httpStatus");
  }

  private static boolean getLogging(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getBoolean("logging");
  }

  public static Map<String, Object> getAnnotationData(AnnotationMetadata importMetadata) {
    return new HashMap<String, Object>() {
      {
        put("field", getField(importMetadata));
        put("objName", getObjName(importMetadata));
        put("param", getParam(importMetadata));
        put("errMessage", getErrMessage(importMetadata));
        put("requestURL", getRequestURL(importMetadata));
        put("method", getMethod(importMetadata));
        put("requestedMethod", getRequestedMethod(importMetadata));
        put("supportedMethod", getSupportedMethod(importMetadata));
        put("trace", getStackTrace(importMetadata));
        put("useCustomResponse", getUseCustomResponse(importMetadata));
        put("httpStatus", getHttpStatus(importMetadata));
        put("message", getMessage(importMetadata));
        put("logging", getLogging(importMetadata));
      }

    };
  }

}
