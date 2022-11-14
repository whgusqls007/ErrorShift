package com.ssafy.e206.response;

import org.springframework.beans.TypeMismatchException;

import java.util.LinkedHashMap;
import java.util.Map;

public class TypeMismatchExceptionResponse {
    private Map<String, Object> details;
    private static StackTraceElement[] stackTrace;

    public Map<String, Object> getDetails() {
        return details;
    }

    private TypeMismatchExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    private static void setStackTraceElement(StackTraceElement[] stackTrace) {
        TypeMismatchExceptionResponse.stackTrace = stackTrace;
    }

    public StackTraceElement[] getStackTrace() {
        return TypeMismatchExceptionResponse.stackTrace;
    }

    public static TypeMismatchExceptionResponse koOf(final TypeMismatchException e) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append(e.getStackTrace()[0].getClassName()).append(" 클래스");
        sb.append(e.getStackTrace()[0].getLineNumber()).append("째 줄 ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" 메소드에서 ");
        sb.append("TypeMismatchException이 발생했습니다.");
        sb.append("요구되는 타입은 '" + e.getRequiredType() +"' 입니다");
        map.put("요약", sb);
        map.put("상세", new LinkedHashMap<String, Object>(){
            {
                put("에러 메시지", e.getMessage() != null ? e.getMessage() : "TypeMismatchExceptio");
                put("에러 발생 위치", new LinkedHashMap<String, Object>(){
                    {
                        put("파일 이름", e.getStackTrace()[0].getFileName());
                        put("클래스 이름", e.getStackTrace()[0].getClassName());
                        put("발생 라인", e.getStackTrace()[0].getLineNumber());
                        put("메소드 이름", e.getStackTrace()[0].getMethodName());
                    }
                });
                put("타입", new LinkedHashMap<String, Object>(){
                    {   
                    
                        put("요구되는 타입", e.getRequiredType());
                        put("값", e.getValue());
                        put("속성 이름", e.getPropertyName());
                        put("에러 코드", e.getErrorCode());
                    }
                });
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new TypeMismatchExceptionResponse(map);
    }

    public static TypeMismatchExceptionResponse enOf(final TypeMismatchException e) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("TypeMismatchException is occurred at ");
        sb.append(e.getStackTrace()[0].getClassName()).append(" Class ");
        sb.append(e.getStackTrace()[0].getLineNumber()).append(" line ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" method.");

        map.put("Summary", sb);
        map.put("Details", new LinkedHashMap<String , Object>(){
            {
                put("Error Message",  e.getMessage() != null ? e.getMessage() : "TypeMismatchExceptio");
                put("Location", new LinkedHashMap<String, Object>() {
                    {
                        put("File Name", e.getStackTrace()[0].getFileName());
                        put("Class Name", e.getStackTrace()[0].getClassName());
                        put("Line Number", e.getStackTrace()[0].getLineNumber());
                        put("Method Name", e.getStackTrace()[0].getMethodName());
                    }
                });
                put("Type", new LinkedHashMap<String, Object>(){
                    {
                        put("Required Type", e.getRequiredType());
                        put("Value", e.getValue());
                        put("Property Name", e.getPropertyName());
                        put("Error Code", e.getErrorCode());
                    }
                });
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new TypeMismatchExceptionResponse(map);
    }

    public static TypeMismatchExceptionResponse of(final TypeMismatchException e, String language) {
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
        return "TypeMismatchException [ " + details + " ]";
    }
}
