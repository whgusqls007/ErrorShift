// package com.ssafy.e206.configuration;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.ImportAware;
// import org.springframework.core.annotation.AnnotationAttributes;
// import org.springframework.core.type.AnnotationMetadata;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.servlet.NoHandlerFoundException;

// import com.ssafy.e206.annotation.TestAnnotations;
// import com.ssafy.e206.response.CommonResponse;
// import com.ssafy.e206.response.error4xx.Error404Response;
// import com.ssafy.e206.response.error5xx.Error500RuntimeExceptionResponse;

// @SuppressWarnings("null")
// @Configuration
// @ControllerAdvice
// @Controller
// public class TestAnnotationsConfig implements ImportAware {

// AnnotationAttributes[] annotationAttributes;

// private void setAnnotationAttributes(AnnotationAttributes[]
// annotationAttributes) {
// this.annotationAttributes = annotationAttributes;
// }

// @ExceptionHandler
// public Object handleException(Exception exception) {
// for (AnnotationAttributes annotationAttribute : this.annotationAttributes) {
// Class<? extends Throwable> exceptionClass =
// annotationAttribute.getClass("exception");
// if (exceptionClass.isInstance(exception) &&
// NoHandlerFoundException.class.isInstance(exception)) {
// System.out.println("NoHandlerFoundException");
// String basePackage = annotationAttribute.getString("basePackage");
// HttpStatus errorCode = annotationAttribute.getEnum("errorCode");
// System.out.println(basePackage);
// if (basePackage.equals("")) {
// return new ResponseEntity<>(Error404Response.of(errorCode, exception),
// HttpStatus.NOT_FOUND);
// } else {
// try {
// Object obj = Class.forName(basePackage).newInstance();
// CommonResponse response = ((CommonResponse) obj).of(errorCode, exception);
// return new ResponseEntity<>(response.of(errorCode, exception), errorCode);
// } catch (ClassNotFoundException | SecurityException | IllegalAccessException
// | IllegalArgumentException | InstantiationException e) {
// e.printStackTrace();
// return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
// }
// }
// } else if (exceptionClass.isInstance(exception) &&
// NullPointerException.class.isInstance(exception)) {
// System.out.println("NullPointerException");
// String basePackage = annotationAttribute.getString("basePackage");
// HttpStatus errorCode = annotationAttribute.getEnum("errorCode");
// if (basePackage.equals("")) {
// return new ResponseEntity<>(Error500RuntimeExceptionResponse.of(errorCode,
// exception),
// errorCode);
// } else {
// try {
// Object obj = Class.forName(basePackage).newInstance();
// CommonResponse response = ((CommonResponse) obj).of(errorCode, exception);
// return new ResponseEntity<>(response.of(errorCode, exception), errorCode);
// } catch (ClassNotFoundException | SecurityException | IllegalAccessException
// | IllegalArgumentException | InstantiationException e) {
// e.printStackTrace();
// return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
// }
// }
// }
// }
// return null;
// }

// private AnnotationAttributes[] getAnnotations(AnnotationMetadata
// importMetadata) {
// return AnnotationAttributes
// .fromMap(importMetadata.getAnnotationAttributes(TestAnnotations.class.getName()))
// .getAnnotationArray("value");
// }

// @Override
// public void setImportMetadata(AnnotationMetadata importMetadata) {
// System.out.println("중복 선언 O");
// AnnotationAttributes[] annotationAttributes = getAnnotations(importMetadata);
// setAnnotationAttributes(annotationAttributes);
// }
// }
