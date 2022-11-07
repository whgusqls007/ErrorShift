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

    public static HttpRequestMethodNotSupportedExceptionResponse of(final HttpRequestMethodNotSupportedException e) {

        Map<String, Object> map = new HashMap<>();
        map.put("errorMessage", e.getMessage() != null ? e.getMessage() : "HttpRequestMethodNotSupportedException");
        map.put("supMetod", e.getSuppressed());
        map.put("rootCause", e.getRootCause());
        map.put("supportedHttpMethods", e.getSupportedHttpMethods());
        map.put("supportedMethods", e.getSupportedMethods());
        map.put("method", e.getMethod());
        map.put("location", new HashMap<String, Object>() {
            {
                put("fileName", e.getStackTrace()[0].getFileName());
                put("className", e.getStackTrace()[0].getClassName());
                put("lineNumber", e.getStackTrace()[0].getLineNumber());
                put("methodName", e.getStackTrace()[0].getMethodName());
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new HttpRequestMethodNotSupportedExceptionResponse(map);
    }
}
