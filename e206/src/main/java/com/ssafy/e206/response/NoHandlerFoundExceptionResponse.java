package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.servlet.NoHandlerFoundException;

public class NoHandlerFoundExceptionResponse {

    private Map<String, Object> details;
    private static StackTraceElement[] stackTrace;

    public Map<String, Object> getDetails() {
        return details;
    }

    private static void setStackTraceElement(StackTraceElement[] stackTrace) {
        NoHandlerFoundExceptionResponse.stackTrace = stackTrace;
    }

    public StackTraceElement[] getStackTrace() {
        return NoHandlerFoundExceptionResponse.stackTrace;
    }

    private NoHandlerFoundExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    public static NoHandlerFoundExceptionResponse koOf(final NoHandlerFoundException e) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("NoHandlerFoundException이 발생했습니다. '");
        sb.append(e.getRequestURL()).append("' 경로에 대한 '").append(e.getHttpMethod());
        sb.append("' 메서드를 찾을 수 없습니다. path와 method를 다시한번 확인 바랍니다.");
      
       
        map.put("요약", sb);
        map.put("상세", new LinkedHashMap<String, Object>(){
            {
                put("에러 메시지",  e.getMessage() != null ? e.getMessage() : "NoHandlerFoundException");

                put("HTTP", new LinkedHashMap<String, Object>(){
                    {
                        put("HTTP 메소드", e.getHttpMethod());
                        put("요청 URL", e.getRequestURL());
                    }
                });
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new NoHandlerFoundExceptionResponse(map);
    }

    public static NoHandlerFoundExceptionResponse enOf(final NoHandlerFoundException e) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("NoHandlerFoundException is occurred. ");
        sb.append("Could not find '").append(e.getHttpMethod()).append("' method for path '");
        sb.append(e.getRequestURL()).append("' Please check again the path and method.");
    

        map.put("Summary", sb);
        map.put("Details", new LinkedHashMap<String , Object>(){
            {
                put("Error Message", e.getMessage() != null ? e.getMessage() : "NoHandlerFoundException");
   
                put("HTTP", new LinkedHashMap<String, Object>(){
                    {
                        put("HTTP Method", e.getHttpMethod());
                        put("Request URL", e.getRequestURL());
                    }
                });

            }
        });
        setStackTraceElement(e.getStackTrace());
        return new NoHandlerFoundExceptionResponse(map);
    }

    public static NoHandlerFoundExceptionResponse of(final NoHandlerFoundException e, String language) {
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
        return "NoHandlerFoundException [ " + details + " ]";
    }
}
