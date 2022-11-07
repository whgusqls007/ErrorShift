package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.Map;

public class IndexOutOfBoundsExceptionResponse {

    private final Map<String, Object> details;
    private static StackTraceElement[] stackTrace;

    public Map<String, Object> getDetails() {
        return details;
    }

    private IndexOutOfBoundsExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    private static void setStackTraceElement(StackTraceElement[] stackTrace) {
        IndexOutOfBoundsExceptionResponse.stackTrace = stackTrace;
    }

    public StackTraceElement[] getStackTrace() {
        return IndexOutOfBoundsExceptionResponse.stackTrace;
    }

    public static IndexOutOfBoundsExceptionResponse of(final IndexOutOfBoundsException e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("errorMessage", e.getMessage() != null ? e.getMessage() : "IndexOutOfBoundsException");
        map.put("location", new HashMap<String, Object>() {
            {
                put("fileName", e.getStackTrace()[0].getFileName());
                put("className", e.getStackTrace()[0].getClassName());
                put("lineNumber", e.getStackTrace()[0].getLineNumber());
                put("methodName", e.getStackTrace()[0].getMethodName());
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new IndexOutOfBoundsExceptionResponse(map);
    }

}
