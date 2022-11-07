package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.Map;

public class NullPointerExceptionResponse {
    private Map<String, Object> details;
    private static StackTraceElement[] stackTrace;

    public Map<String, Object> getDetails() {
        return details;
    }

    private static void setStackTraceElement(StackTraceElement[] stackTrace) {
        NullPointerExceptionResponse.stackTrace = stackTrace;
    }

    public StackTraceElement[] getStackTrace() {
        return this.stackTrace;
    }

    private NullPointerExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    public static NullPointerExceptionResponse of(final NullPointerException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("errorMessage", e.getMessage());
        map.put("location", new HashMap<String, Object>() {
            {
                put("fileName", e.getStackTrace()[0].getFileName());
                put("className", e.getStackTrace()[0].getClassName());
                put("lineNumber", e.getStackTrace()[0].getLineNumber());
                put("methodName", e.getStackTrace()[0].getMethodName());
            }
        });

        setStackTraceElement(e.getStackTrace());
        return new NullPointerExceptionResponse(map);
    }
}
