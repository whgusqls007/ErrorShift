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
import com.ssafy.e206.annotation.TestAnnotations;
import com.ssafy.e206.errorCode.ErrorCode;

@SuppressWarnings("null")
@Configuration
@ControllerAdvice
public class TestAnnotationSelector implements ImportAware {
  Class<? extends Throwable>[] exception;
  AnnotationAttributes[] annotationAttributes;

  private void setAnnotationAttributes(AnnotationAttributes[] annotationAttributes) {
    this.annotationAttributes = annotationAttributes;
  }

  private void setException(Class<? extends Throwable>[] exception) {
    this.exception = exception;
  }

  @ExceptionHandler
  public ResponseEntity<String> handleException(Exception exception) {
    for (int i = 0; i < this.annotationAttributes.length; i++) {
      if (this.annotationAttributes[i].getClass("exception").isInstance(exception)) {
        return new ResponseEntity<>(this.annotationAttributes[i].getString("message"), annotationAttributes[i].getEnum("errorCode"));
      }
    }
    return new ResponseEntity<>("asdasdasdasdasd", HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ErrorCode getErrorCode(AnnotationMetadata importingClassMetadata) {
    return AnnotationAttributes
        .fromMap(importingClassMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getEnum("errorCode");
  }

  private String getMessage(AnnotationMetadata importingClassMetadata) {
    return AnnotationAttributes
        .fromMap(importingClassMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getString("message");
  }

  private int getStatus(AnnotationMetadata importingClassMetadata) {
    return AnnotationAttributes
        .fromMap(importingClassMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getNumber("status");
  }

  private Class<? extends Throwable> getException(AnnotationMetadata importingClassMetadata) {
    return AnnotationAttributes
        .fromMap(importingClassMetadata.getAnnotationAttributes(TestAnnotation.class.getName()))
        .getClass("exception");
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
    // List<Class<? extends Throwable>> exceptionList = new ArrayList<>();

    // for (int i = 0; i < annotationAttributes.length; i++) {
    // exceptionList.add(annotationAttributes[i].getClass("exception"));
    // }

    // setException(exceptionList.toArray(new Class[exceptionList.size()]));

    // Class<? extends Throwable> exception = getException(importingClassMetadata);
    // this.setException(exception);
    // System.out
    // .println("File: TestAnnotationSelector.java ~ line: (45) ~ function:
    // voidsetImportMetadata ---> exception: "
    // + exception);

    // ErrorCode errorCode = getErrorCode(importingClassMetadata);
    // System.out
    // .println("File: TestAnnotationSelector.java ~ line: (47) ~ function:
    // voidsetImportMetadata ---> errorCode: "
    // + errorCode);

    // String message = getMessage(importingClassMetadata);
    // System.out.println(
    // "File: TestAnnotationSelector.java ~ line: (49) ~ function:
    // voidsetImportMetadata ---> message: " + message);

    // int status = getStatus(importingClassMetadata);
    // System.out.println(
    // "File: TestAnnotationSelector.java ~ line: (51) ~ function:
    // voidsetImportMetadata ---> status: " + status);

  }
}
