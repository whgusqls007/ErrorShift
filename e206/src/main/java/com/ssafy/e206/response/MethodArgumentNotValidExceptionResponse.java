package com.ssafy.e206.response;

import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
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

    public static MethodArgumentNotValidExceptionResponse of(final MethodArgumentNotValidException e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("errorMessage", e.getMessage() != null ? e.getMessage() : "MethodArgumentNotValidException");
        map.put("parameter", e.getParameter());
        map.put("location", new HashMap<String, Object>() {
            {
                put("fileName", e.getStackTrace()[0].getFileName());
                put("className", e.getStackTrace()[0].getClassName());
                put("lineNumber", e.getStackTrace()[0].getLineNumber());
                put("methodName", e.getStackTrace()[0].getMethodName());
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new MethodArgumentNotValidExceptionResponse(map);
    }

    @Override
    public String toString() {
        return "MethodArgumentNotValidException [ " + details + " ]";
    }
}
