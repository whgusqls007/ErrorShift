package com.ssafy.e206.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ssafy.e206.annotation.TestAnnotation;
import com.ssafy.e206.response.CommonResponse;
import com.ssafy.e206.response.error4xx.Error404Response;

@SuppressWarnings("null")
@Configuration
@ControllerAdvice
public class TestAnnotationConfig implements ImportAware {
  Class<? extends Throwable> exception;
  HttpStatus errorCode;
  String basePackage;

  private void setAnnotationAttributes(Class<? extends Throwable> exception,
      HttpStatus errorCode,
      String basePackage) {
    this.exception = exception;
    this.errorCode = errorCode;
    this.basePackage = basePackage;
  }

  @ExceptionHandler
  public ResponseEntity<Object> handleException(Exception exception) {
    if (this.exception.isInstance(exception)) {
      if (this.basePackage.equals("")) {
        return new ResponseEntity<>(Error404Response.of(this.errorCode, exception),
            this.errorCode);
      } else {
        try {
          Object obj = Class.forName(this.basePackage).newInstance();
          CommonResponse response = ((CommonResponse) obj).of(this.errorCode, exception);
          return new ResponseEntity<>(response.of(this.errorCode, exception), this.errorCode);
        } catch (ClassNotFoundException | SecurityException | IllegalAccessException
            | IllegalArgumentException | InstantiationException e) {
          e.printStackTrace();
          return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }

    }
    return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private Class<? extends Throwable> getExceptionClass(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getClass("exception");
  }

  private HttpStatus getHttpStatus(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getEnum("errorCode");
  }

  private String getBasePackage(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getString("basePackage");
  }

  @Override
  public void setImportMetadata(AnnotationMetadata importMetadata) {
    System.out.println("중복 선언 X");
    Class<? extends Throwable> exceptionClass = getExceptionClass(importMetadata);
    HttpStatus httpStatus = getHttpStatus(importMetadata);
    String basePackage = getBasePackage(importMetadata);
    setAnnotationAttributes(exceptionClass, httpStatus, basePackage);
  }
}
