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

    public static NoHandlerFoundExceptionResponse of(final NoHandlerFoundException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("errorMessage", e.getMessage() != null ? e.getMessage() : "NoHandlerFoundException");
        map.put("RequestURL", e.getRequestURL());
        map.put("HttpMethod", e.getHttpMethod());
        map.put("Header", e.getHeaders());
        map.put("location", new HashMap<String, Object>() {
            {
                put("fileName", e.getStackTrace()[0].getFileName());
                put("className", e.getStackTrace()[0].getClassName());
                put("lineNumber", e.getStackTrace()[0].getLineNumber());
                put("methodName", e.getStackTrace()[0].getMethodName());
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new NoHandlerFoundExceptionResponse(map);

    }
}
