package com.ssafy.e206.response;

import java.util.HashMap;
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
        HashMap<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append(e.getStackTrace()[0].getClassName()).append(" 클래스");
        sb.append(e.getStackTrace()[0].getLineNumber()).append("째 줄 ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" 메소드에서");
        sb.append("NoHandlerFoundException 발생했습니다.");
        map.put("요약", sb);
        map.put("상세", new HashMap<String, Object>(){
            {
                put("에러 메시지", "NoHandlerFoundException");
                put("에러 발생 위치", new HashMap<String, Object>(){
                    {
                        put("파일 이름", e.getStackTrace()[0].getFileName());
                        put("클래스 이름", e.getStackTrace()[0].getClassName());
                        put("발생 라인", e.getStackTrace()[0].getLineNumber());
                        put("메소드 이름", e.getStackTrace()[0].getMethodName());
                    }
                });
                put("HTTP", new HashMap<String, Object>(){
                    {
                        put("헤더", e.getHeaders());
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
        HashMap<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("NoHandlerFoundException is occurred at ");
        sb.append(e.getStackTrace()[0].getClassName()).append(" Class ");
        sb.append(e.getStackTrace()[0].getLineNumber()).append(" line ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" method.");

        map.put("Summary", sb);
        map.put("Details", new HashMap<String , Object>(){
            {
                put("Error Message", "NoHandlerFoundException");
                put("Location", new HashMap<String, Object>() {
                    {
                        put("File Name", e.getStackTrace()[0].getFileName());
                        put("Class Name", e.getStackTrace()[0].getClassName());
                        put("Line Number", e.getStackTrace()[0].getLineNumber());
                        put("Method Name", e.getStackTrace()[0].getMethodName());
                    }
                });
                put("HTTP", new HashMap<String, Object>(){
                    {
                        put("Headers", e.getHeaders());
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
