package com.ssafy.e206.util;

import java.util.HashMap;
import java.util.Map;

import com.ssafy.e206.response.ArithmeticExceptionResponse;
import com.ssafy.e206.response.HttpMediaTypeNotSupportedExceptionResponse;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;

@SuppressWarnings("unchecked")
public class ResponseAttribute {

  public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
      AnnotationAttributes annotationAttributes, Throwable exception, Class<? extends Throwable> handleException) {
    Map<String, Object> datas = GetAnnotationData.getAnnotationData(annotationAttributes);
    System.out.println("++++++++++++++ ResponseAttribute getResponseAttribute() called start ++++++++++++++");
    System.out.println(result.toString());

//    result.clear();

    // timestamp, status, error
    if (datas.get("status") != null) {
      result.put("status", ((HttpStatus) datas.get("httpStatus")).value());
    }

    if (!datas.get("message").equals("")) {
      result.put("userMessage", datas.get("message"));
    }

    System.out.println(result.toString());

//    System.out.println("ResponseAttribute getResponseAttribute exception: "+exception);
//    System.out.println("ResponseAttribute getResponseAttribute exception.getMessage(): "+exception.getMessage());
//    System.out.println("ResponseAttribute getResponseAttribute handleException: "+handleException);
//    System.out.println("ResponseAttribute getResponseAttribute handleException.getName(): "+handleException.getName());

    StringBuffer stringBuffer = new StringBuffer(result.get("exception").toString());
    stringBuffer.reverse();
    String[] sbs = stringBuffer.toString().split("\\.");
    stringBuffer = new StringBuffer(sbs[0]);
    stringBuffer.reverse();
    System.out.println("sb.toString(): "+stringBuffer.toString());
//    String exceptionClass = result.get("exception").toString();
    String exceptionClass = stringBuffer.toString();
    System.out.println("exceptionClass: "+exceptionClass);
    if (exceptionClass.equals("HttpMediaTypeNotSupportedException")) {
      System.out.println("if HttpMediaTypeNotSupportedException");
      HttpMediaTypeNotSupportedException e = (HttpMediaTypeNotSupportedException) exception;
      HttpMediaTypeNotSupportedExceptionResponse res = HttpMediaTypeNotSupportedExceptionResponse.of(e);
//      result.putAll(res.getDetails());
      result.put("details", res.getDetails());
    }
    else if (exceptionClass.equals("ArithmeticException")) {
      System.out.println("if ArithmeticException");
      ArithmeticException e = (ArithmeticException) exception;
      ArithmeticExceptionResponse res = ArithmeticExceptionResponse.of(e);
      result.put("details", res.getDetails());
    }
    else if (exceptionClass.equals("NullPointerException")) {
      System.out.println("if NullPointerException");
      NullPointerException e = (NullPointerException) exception;
    }

//    if (datas.get("response") == null) {
//
//    }
    result.remove("message");
    System.out.println(result.toString());
    System.out.println("++++++++++++++ ResponseAttribute getResponseAttribute() called end ++++++++++++++");
    return result;
  }

  public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
      Class<? extends Throwable> exception,
      Map<String, Object> annotationData) {

    return result;
  }
}
