package com.ssafy.e206.configuration;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import com.ssafy.e206.annotation.TestAnnotations;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes implements ImportAware {

  private AnnotationAttributes[] annotationAttributes;

  public void setAnnotationAttributes(AnnotationAttributes[] annotationAttributes) {
    this.annotationAttributes = annotationAttributes;
  }

  @Override
  public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
    Map<String, Object> result = super.getErrorAttributes(webRequest, options);
    Throwable error = super.getError(webRequest);
    for (AnnotationAttributes annotationAttribute : this.annotationAttributes) {
      if (annotationAttribute.getClass("exception").isInstance(error)) {
        result.clear();
        result.put("asdasd", "123123");
      }
    }
    return result;
  }

  @SuppressWarnings("null")
  private AnnotationAttributes[] getAnnotations(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotations.class.getName()))
        .getAnnotationArray("value");
  }

  @Override
  public void setImportMetadata(AnnotationMetadata importMetadata) {
    AnnotationAttributes[] annotationAttributes = getAnnotations(importMetadata);
    setAnnotationAttributes(annotationAttributes);
  }
}