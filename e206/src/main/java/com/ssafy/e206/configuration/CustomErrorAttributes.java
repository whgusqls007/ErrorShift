package com.ssafy.e206.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import com.ssafy.e206.util.GetAnnotationData;
import com.ssafy.e206.util.ResponseAttribute;

@Component
@SuppressWarnings("null")
public class CustomErrorAttributes extends DefaultErrorAttributes implements ImportAware {

  private AnnotationAttributes[] annotationAttributes;
  private Class<? extends Throwable> exception;
  private Map<String, Object> annotationData;

  private void setAnnotationAttributes(AnnotationAttributes[] annotationAttributes) {
    this.annotationAttributes = annotationAttributes;
    this.exception = null;
    this.annotationData = null;
  }

  private void setAnnotationAttributes(Class<? extends Throwable> exception, Map<String, Object> annotationData) {
    this.annotationAttributes = null;
    this.exception = exception;
    this.annotationData = annotationData;
  }

  @Override
  public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
    Map<String, Object> result = super.getErrorAttributes(webRequest, options);
    Throwable error = super.getError(webRequest);
    if (this.annotationAttributes != null) {
      for (AnnotationAttributes annotationAttribute : this.annotationAttributes) {
        Class<? extends Throwable> handleException = annotationAttribute.getClass("exception");
        if (handleException.isInstance(error)) {
          result = ResponseAttribute.getResponseAttribute(result, annotationAttribute, error, handleException);
        }
      }
    } else {
      System.out.println("나중에");
    }
    return result;
  }

  @Override
  public void setImportMetadata(AnnotationMetadata importMetadata) {
    AnnotationAttributes[] annotationAttributes = GetAnnotationData.getAnnotations(importMetadata);
    if (annotationAttributes != null || annotationAttributes.length != 0) {
      setAnnotationAttributes(annotationAttributes);
    } else {
      setAnnotationAttributes(
          GetAnnotationData.getExceptionClass(importMetadata),
          new HashMap<String, Object>() {
            {
              put("field", GetAnnotationData.getField(importMetadata));
              put("objName", GetAnnotationData.getObjName(importMetadata));
              put("param", GetAnnotationData.getParam(importMetadata));
              put("errMessage", GetAnnotationData.getErrMessage(importMetadata));
              put("requestURL", GetAnnotationData.getRequestURL(importMetadata));
              put("method", GetAnnotationData.getMethod(importMetadata));
              put("requestedMethod", GetAnnotationData.getRequestedMethod(importMetadata));
              put("supportedMethod", GetAnnotationData.getSupportedMethod(importMetadata));
            }
          });
    }
  }
}