package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

public class NumberFormatExceptionResponse {
    private Map<String, Object> details;
    private static StackTraceElement[] stackTrace;

    public Map<String, Object> getDetails() {
        return details;
    }

    private NumberFormatExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    private static void setStackTraceElement(StackTraceElement[] stackTrace) {
        NumberFormatExceptionResponse.stackTrace = stackTrace;
    }

    public StackTraceElement[] getStackTrace() {
        return NumberFormatExceptionResponse.stackTrace;
    }

    public static NumberFormatExceptionResponse koOf(final NumberFormatException e) {
        HashMap<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append(e.getStackTrace()[0].getClassName()).append(" 클래스 ");
        sb.append(e.getStackTrace()[0].getLineNumber()).append("째 줄 ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" 메소드에서 ");
        sb.append("NumberFormatException이 발생했습니다.");
        map.put("요약", sb);
        map.put("상세", new HashMap<String, Object>(){
            {
                put("에러 메시지", e.getMessage() != null ? e.getMessage() : "NumberFormatException");
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
        return new NumberFormatExceptionResponse(map);
    }

    public static NumberFormatExceptionResponse enOf(final NumberFormatException e) {
        HashMap<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("NumberFormatException is occurred at ");
        sb.append(e.getStackTrace()[0].getClassName()).append(" Class ");
        sb.append(e.getStackTrace()[0].getLineNumber()).append(" line ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" method.");

        map.put("Summary", sb);
        map.put("Details", new HashMap<String , Object>(){
            {
                put("Error Message", e.getMessage() != null ? e.getMessage() : "NumberFormatException");
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
        return new NumberFormatExceptionResponse(map);
    }

    public static NumberFormatExceptionResponse of(final NumberFormatException e, String language) {
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
        return "NumberFormatException [ " + details + " ]";
    }
}
