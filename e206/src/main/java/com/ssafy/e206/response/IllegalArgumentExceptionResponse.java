package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.Map;

public class IllegalArgumentExceptionResponse {

    private Map<String, Object> details;
    private static StackTraceElement[] stackTrace;

    public Map<String, Object> getDetails() {
        return details;
    }

    private static void setStackTraceElement(StackTraceElement[] stackTrace) {
        IllegalArgumentExceptionResponse.stackTrace = stackTrace;
    }

    public StackTraceElement[] getStackTrace() {
        return IllegalArgumentExceptionResponse.stackTrace;
    }

    private IllegalArgumentExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    public static IllegalArgumentExceptionResponse of(final IllegalArgumentException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("errorMessage", e.getMessage() != null ? e.getMessage() : "IllegalArgumentException");
        map.put("supMetod", e.getSuppressed());
        map.put("localinitialize", e.getLocalizedMessage());
        map.put("Suppressed", e.getSuppressed());
        map.put("location", new HashMap<String, Object>() {
            {
                put("fileName", e.getStackTrace()[0].getFileName());
                put("className", e.getStackTrace()[0].getClassName());
                put("lineNumber", e.getStackTrace()[0].getLineNumber());
                put("methodName", e.getStackTrace()[0].getMethodName());
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new IllegalArgumentExceptionResponse(map);
    }

    @Override
    public String toString() {
        return "IllegalArgumentNotSupportedException [ " + details + " ]";
    }
}