package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.HttpRequestMethodNotSupportedException;

public class HttpRequestMethodNotSupportedExceptionResponse {

    private Map<String, Object> details;
    private static StackTraceElement[] stackTrace;

    public Map<String, Object> getDetails() {
        return details;
    }

    private HttpRequestMethodNotSupportedExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    private static void setStackTraceElement(StackTraceElement[] stackTrace) {
        HttpRequestMethodNotSupportedExceptionResponse.stackTrace = stackTrace;
    }

    public StackTraceElement[] getStackTrace() {
        return HttpRequestMethodNotSupportedExceptionResponse.stackTrace;
    }
    public static HttpRequestMethodNotSupportedExceptionResponse koOf(final HttpRequestMethodNotSupportedException e) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
       

        sb.append("지원되는 메소드는 '").append(e.getSupportedHttpMethods()).append("'지만 ");
        sb.append("현재 요청하신 메소드는 '[").append(e.getMethod()).append("]' 입니다");
        map.put("요약", sb);
        map.put("상세", new HashMap<String, Object>(){
            {
                put("에러 메시지", e.getMessage() != null ? e.getMessage() : "HttpRequestMethodNotSupportedException");
                put("메소드 정보", new HashMap<String, Object>(){
                    {
                        put("지원되는 메소드", e.getSupportedMethods());
                        put("요청 메소드", e.getMethod());
                    }
                });
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new HttpRequestMethodNotSupportedExceptionResponse(map);
    }

    public static HttpRequestMethodNotSupportedExceptionResponse enOf(final HttpRequestMethodNotSupportedException e) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
       
        sb.append("The supported method' is '").append(e.getSupportedHttpMethods()).append("', ");
        sb.append("but requested method' is '[").append(e.getMethod()+"]'");
        sb.append(". Please check again");
      

        map.put("Summary", sb);
        map.put("Details", new HashMap<String , Object>(){
            {
                put("Error Message", e.getMessage() != null ? e.getMessage() : "HttpRequestMethodNotSupportedException");
                put("Method Info", new HashMap<String, Object>(){
                    {
                        put("Supported HTTP Methods", e.getSupportedHttpMethods());
                        
                        put("Rquested Method", e.getMethod());
                    }
                });
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new HttpRequestMethodNotSupportedExceptionResponse(map);
    }

    public static HttpRequestMethodNotSupportedExceptionResponse of(final HttpRequestMethodNotSupportedException e, String language) {
       
        switch (language) {
            case "en":
                return enOf(e);
            case "ko":
                return koOf(e);
            default:
                return enOf(e);
        }
    }

    @Override
    public String toString() {
        return "HttpRequestMethodNotSupportedException [ " + details + " ]";
    }
}
