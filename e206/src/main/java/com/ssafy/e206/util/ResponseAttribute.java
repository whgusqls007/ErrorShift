package com.ssafy.e206.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ResponseAttribute {

  public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
      AnnotationAttributes annotationAttributes, Throwable exception) {
    Map<String, Object> datas = GetAnnotationData.getAnnotationData(annotationAttributes);
    Class<? extends Throwable> handleException = (Class<? extends Throwable>) datas.get("exception");
    if (handleException.isInstance(exception)) {
      System.out.println("234234234");
    } else {
      System.out.println("345345345");
    }
    return result;
  }

  public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
      Class<? extends Throwable> exception,
      Map<String, Object> annotationData) {

    return result;
  }
}
