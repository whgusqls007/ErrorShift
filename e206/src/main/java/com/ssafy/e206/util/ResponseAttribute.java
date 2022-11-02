package com.ssafy.e206.util;

import java.util.Map;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;

@SuppressWarnings("unchecked")
public class ResponseAttribute {

  public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
      AnnotationAttributes annotationAttributes, Throwable exception, Class<? extends Throwable> handleException) {
    Map<String, Object> datas = GetAnnotationData.getAnnotationData(annotationAttributes);

    if (datas.get("status") != null) {
      result.put("status", ((HttpStatus) datas.get("httpStatus")).value());
    }

    if (datas.get("message").equals("")) {
      result.put("userMessage", datas.get("message"));
    }
    
    return result;
  }

  public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
      Class<? extends Throwable> exception,
      Map<String, Object> annotationData) {

    return result;
  }
}
