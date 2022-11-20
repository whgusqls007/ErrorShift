package com.ssafy.e206.response;

import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MethodArgumentNotValidExceptionResponse {
    private Map<String, Object> details;
    private static StackTraceElement[] stackTrace;

    public Map<String, Object> getDetails() {
        return details;
    }

    private MethodArgumentNotValidExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    private static void setStackTraceElement(StackTraceElement[] stackTrace) {
        MethodArgumentNotValidExceptionResponse.stackTrace = stackTrace;
    }

    public StackTraceElement[] getStackTrace() {
        return MethodArgumentNotValidExceptionResponse.stackTrace;
    }
    public static MethodArgumentNotValidExceptionResponse koOf(final MethodArgumentNotValidException e) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append(e.getStackTrace()[0].getClassName()).append(" 클래스 ");
        sb.append(e.getStackTrace()[0].getLineNumber()).append("째 줄 ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" 메소드에서 ");
        sb.append("MethodArgumentNotValidException이 발생했습니다.");
        map.put("요약", sb);
        map.put("상세", new HashMap<String, Object>(){
            {
                put("파라미터", e.getParameter());
                put("메시지", e.getMessage());
                put("에러 메시지", e.getMessage() != null ? e.getMessage() : "MethodArgumentNotValidException");
                put("에러 발생 위치", new HashMap<String, Object>(){
                    {
                        put("파일 이름", e.getStackTrace()[0].getFileName());
                        put("클래스 이름", e.getStackTrace()[0].getClassName());
                        put("발생 라인", e.getStackTrace()[0].getLineNumber());
                        put("메소드 이름", e.getStackTrace()[0].getMethodName());
                    }
                });
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new MethodArgumentNotValidExceptionResponse(map);
    }

    public static MethodArgumentNotValidExceptionResponse enOf(final MethodArgumentNotValidException e) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("MethodArgumentNotValidException is occurred at ");
        sb.append(e.getStackTrace()[0].getClassName()).append(" Class ");
        sb.append(e.getStackTrace()[0].getLineNumber()).append(" line ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" method.");

        map.put("Summary", sb);
        map.put("Details", new HashMap<String , Object>(){
            {
                put("Parameter", e.getParameter());
                put("Message", e.getMessage());
                put("Error Message", e.getMessage() != null ? e.getMessage() : "MethodArgumentNotValidException");
                put("Location", new HashMap<String, Object>() {
                    {
                        put("File Name", e.getStackTrace()[0].getFileName());
                        put("Class Name", e.getStackTrace()[0].getClassName());
                        put("Line Number", e.getStackTrace()[0].getLineNumber());
                        put("Method Name", e.getStackTrace()[0].getMethodName());
                    }
                });

            }
        });
        setStackTraceElement(e.getStackTrace());
        return new MethodArgumentNotValidExceptionResponse(map);
    }

    public static MethodArgumentNotValidExceptionResponse of(final MethodArgumentNotValidException e, String language) {
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
        return "MethodArgumentNotValidException [ " + details + " ]";
    }
}
