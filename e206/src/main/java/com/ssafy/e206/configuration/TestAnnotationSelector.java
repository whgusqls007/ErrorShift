package com.ssafy.e206.configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.function.ServerResponse.Context;

import com.ssafy.e206.annotation.TestAnnotations;
import com.ssafy.e206.response.CommonResponse;

@SuppressWarnings("null")
@Configuration
@ControllerAdvice
public class TestAnnotationSelector implements ImportAware {
  AnnotationAttributes[] annotationAttributes;

  private void setAnnotationAttributes(AnnotationAttributes[] annotationAttributes) {
    this.annotationAttributes = annotationAttributes;
  }

  @ExceptionHandler
  public ResponseEntity<String> handleException(Exception exception) {

    try {
      Object obj = Class.forName(this.annotationAttributes[0].getString("basePackage")).newInstance();
      CommonResponse response = (CommonResponse) obj;
      response.aaaa();
      // Method m = obj.getClass().getDeclaredMethod("aaaa", new Class<?>[0]);
      // m.invoke(obj);
    } catch (ClassNotFoundException | SecurityException | IllegalAccessException
        | IllegalArgumentException | InstantiationException e) {
      e.printStackTrace();
      return new ResponseEntity<>("aaaa 없음", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    for (int i = 0; i < this.annotationAttributes.length; i++) {
      if (this.annotationAttributes[i].getClass("exception").isInstance(exception)) {
        HttpStatus httpStatus = this.annotationAttributes[i].getEnum("errorCode");
        return new ResponseEntity<>(httpStatus.toString(), httpStatus);
      }
    }
    return new ResponseEntity<>("asdasdasdasdasd", HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private AnnotationAttributes[] getAnnotation(AnnotationMetadata importingClassMetadata) {
    return AnnotationAttributes
        .fromMap(importingClassMetadata.getAnnotationAttributes(TestAnnotations.class.getName()))
        .getAnnotationArray("value");
  }

  @Override
  public void setImportMetadata(AnnotationMetadata importingClassMetadata) {
    System.out.println(":asdfasdfasdf");
    AnnotationAttributes[] annotationAttributes = getAnnotation(importingClassMetadata);
    setAnnotationAttributes(annotationAttributes);
  }
}
