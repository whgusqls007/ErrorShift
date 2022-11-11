package com.ssafy.e206.response;

import java.util.HashMap;
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
        HashMap<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append(e.getStackTrace()[0].getClassName()).append(" 클래스");
        sb.append(e.getStackTrace()[0].getLineNumber()).append("째 줄 ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" 메소드에서");
        sb.append("HttpRequestMethodNotSupportedException 발생했습니다.");
        map.put("요약", sb);
        map.put("상세", new HashMap<String, Object>(){
            {
                put("에러 메시지", "HttpRequestMethodNotSupportedException");
                put("에러 발생 위치", new HashMap<String, Object>(){
                    {
                        put("파일 이름", e.getStackTrace()[0].getFileName());
                        put("클래스 이름", e.getStackTrace()[0].getClassName());
                        put("발생 라인", e.getStackTrace()[0].getLineNumber());
                        put("메소드 이름", e.getStackTrace()[0].getMethodName());
                    }
                });
                put("메소드 정보", new HashMap<String, Object>(){
                    {
                        put("지원되는 HTTP 메소드", e.getSupportedHttpMethods());
                        put("지원되는 메소드", e.getSupportedMethods());
                        put("메소드", e.getMethod());
                    }
                });
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new HttpRequestMethodNotSupportedExceptionResponse(map);
    }

    public static HttpRequestMethodNotSupportedExceptionResponse enOf(final HttpRequestMethodNotSupportedException e) {
        HashMap<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("HttpRequestMethodNotSupportedException is occurred at ");
        sb.append(e.getStackTrace()[0].getClassName()).append(" Class ");
        sb.append(e.getStackTrace()[0].getLineNumber()).append(" line ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" method.");

        map.put("Summary", sb);
        map.put("Details", new HashMap<String , Object>(){
            {
                put("Error Message", "HttpRequestMethodNotSupportedException");
                put("Location", new HashMap<String, Object>() {
                    {
                        put("File Name", e.getStackTrace()[0].getFileName());
                        put("Class Name", e.getStackTrace()[0].getClassName());
                        put("Line Number", e.getStackTrace()[0].getLineNumber());
                        put("Method Name", e.getStackTrace()[0].getMethodName());
                    }
                });
                put("Method Info", new HashMap<String, Object>(){
                    {
                        put("Supported HTTP Methods", e.getSupportedHttpMethods());
                        put("Supported Methods", e.getSupportedMethods());
                        put("Method", e.getMethod());
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
