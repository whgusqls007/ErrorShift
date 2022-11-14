package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.HttpMediaTypeNotSupportedException;

@SuppressWarnings("null")
public class HttpMediaTypeNotSupportedExceptionResponse {
    private Map<String, Object> details;
    private static StackTraceElement[] stackTrace;

    public Map<String, Object> getDetails() {
        return details;
    }

    private static void setStackTraceElement(StackTraceElement[] stackTrace) {
        HttpMediaTypeNotSupportedExceptionResponse.stackTrace = stackTrace;
    }

    public StackTraceElement[] getStackTrace() {
        return HttpMediaTypeNotSupportedExceptionResponse.stackTrace;
    }

    private HttpMediaTypeNotSupportedExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    public static HttpMediaTypeNotSupportedExceptionResponse koOf(final HttpMediaTypeNotSupportedException e) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append(e.getStackTrace()[0].getClassName()).append(" 클래스 ");
        sb.append(e.getStackTrace()[0].getLineNumber()).append("째 줄 ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" 메소드에서 ");
        sb.append("HttpMediaTypeNotSupportedException이 발생했습니다.");
        map.put("요약", sb);
        map.put("상세", new HashMap<String, Object>() {
            {
                put("에러 메시지", e.getMessage() != null ? e.getMessage() : "HttpMediaTypeNotSupportedException");
                put("에러 발생 위치", new HashMap<String, Object>() {
                    {
                        put("파일 이름", e.getStackTrace()[0].getFileName());
                        put("클래스 이름", e.getStackTrace()[0].getClassName());
                        put("발생 라인", e.getStackTrace()[0].getLineNumber());
                        put("메소드 이름", e.getStackTrace()[0].getMethodName());
                    }
                });
                put("콘텐츠", new HashMap<String, Object>() {
                    {
                        if (e.getContentType() != null) {
                            put("콘텐츠 타입", e.getContentType().toString());
                        }
                        put("지원되는 미디어 타입", e.getSupportedMediaTypes().toString());
                    }
                });
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new HttpMediaTypeNotSupportedExceptionResponse(map);
    }

    public static HttpMediaTypeNotSupportedExceptionResponse enOf(final HttpMediaTypeNotSupportedException e) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("HttpMediaTypeNotSupportedException is occurred at ");
        sb.append(e.getStackTrace()[0].getClassName()).append(" Class ");
        sb.append(e.getStackTrace()[0].getLineNumber()).append(" line ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" method.");

        map.put("Summary", sb);
        map.put("Details", new HashMap<String, Object>() {
            {
                put("Error Message", e.getMessage() != null ? e.getMessage() : "HttpMediaTypeNotSupportedException");
                put("Location", new HashMap<String, Object>() {
                    {
                        put("File Name", e.getStackTrace()[0].getFileName());
                        put("Class Name", e.getStackTrace()[0].getClassName());
                        put("Line Number", e.getStackTrace()[0].getLineNumber());
                        put("Method Name", e.getStackTrace()[0].getMethodName());
                    }
                });
                put("Content", new HashMap<String, Object>() {
                    {
                        if (e.getContentType() != null) {
                            put("Content Type", e.getContentType().toString());
                        }
                        put("Supported Media Type", e.getSupportedMediaTypes().toString());
                    }
                });

            }
        });
        setStackTraceElement(e.getStackTrace());
        return new HttpMediaTypeNotSupportedExceptionResponse(map);
    }

    public static HttpMediaTypeNotSupportedExceptionResponse of(final HttpMediaTypeNotSupportedException e,
            String language) {
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
        return "HttpMediaTypeNotSupportedException [ " + details + " ]";
    }
}
