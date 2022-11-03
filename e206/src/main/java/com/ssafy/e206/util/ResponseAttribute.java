package com.ssafy.e206.util;

import java.util.Map;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.ssafy.e206.response.HttpRequestMethodNotSupportedExceptionResponse;
import com.ssafy.e206.response.IllegalArgumentExceptionResponse;

@SuppressWarnings("unchecked")
public class ResponseAttribute {

  public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
      AnnotationAttributes annotationAttributes, Throwable exception, Class<? extends Throwable> handleException) {
    Map<String, Object> datas = GetAnnotationData.getAnnotationData(annotationAttributes);
        System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
    if (datas.get("status") != null) {
        

      result.put("status", ((HttpStatus) datas.get("httpStatus")).value());
    }
    
    System.out.println("TTT@2222222222222222222222222222222222222222222222222222222222");
    if (datas.get("message").equals("")) {
      System.out.println("IF 시작");
      result.put("userMessage", datas.get("message"));
      System.out.println("IF 끝나기 전");
    }
    
    String str = splitLastString(exception.getClass().toString(), '.');
    System.out.println(str);
    // System.out.println(splitLastString(exception.getClass().toString(), '.') + " 겟클래스 겟 네임");
    if(str.equals("HttpRequestMethodNotSupportedException")){
      System.out.println(result.get("path") + "PATH 입니다");
      System.out.println(" 들어왔나");
      HttpRequestMethodNotSupportedException e = (HttpRequestMethodNotSupportedException) exception;
      System.out.println("여긴가");
      // result.clear();
      result.put("Test",HttpRequestMethodNotSupportedExceptionResponse.of(e));
      System.out.println("마지막줄");
    }

    else if(str.equals("IllegalArgumentException")){
      System.out.println("Illegal 들어옴");
      IllegalArgumentException e = (IllegalArgumentException)exception;
      System.out.println("result 전");
      result.put("Illegal", IllegalArgumentExceptionResponse.of(e));
      System.out.println(" else if ");
      
    }

  
    else {
      System.out.println("ELSE 시작" + result.toString());
      result.put("userMessage@@@@", datas.get("message"));
    }
    
    
    System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRrr" + result.toString());
    return result;
  }

  public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
      Class<? extends Throwable> exception,
      Map<String, Object> annotationData) {

    return result;
  }

  private static String splitLastString(String target, char deliminator) {
    int x = target.lastIndexOf(deliminator);
    if (x > 0) return target.substring(x + 1);
    return target;
}
}
