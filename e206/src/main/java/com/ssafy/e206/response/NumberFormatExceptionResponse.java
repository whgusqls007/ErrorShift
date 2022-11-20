package com.ssafy.e206.response;

import java.util.LinkedHashMap;
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
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();

        sb.append("NumberFormatException이 발생했습니다. 문자형을 숫자형으로 잘못 변경 시 발생하는 에러입니다.");
        sb.append(" 요청 URL과 에러 메세지를 확인해주세요.");
        map.put("요약", sb);
        map.put("상세", new LinkedHashMap<String, Object>() {
            {
                put("에러 메시지", e.getMessage() != null ? e.getMessage() : "NumberFormatException");
                put("에러 발생 위치", new LinkedHashMap<String, Object>() {
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
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("NumberFormatException is occurred  ");
        sb.append("This error occurs when a character type is incorrectly changed to a numeric type.");
        sb.append(" Please check the request URL and error message.");
     

        map.put("Summary", sb);
        map.put("Details", new LinkedHashMap<String, Object>() {
            {
                put("Error Message", e.getMessage() != null ? e.getMessage() : "NumberFormatException");
                put("Location", new LinkedHashMap<String, Object>() {
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
