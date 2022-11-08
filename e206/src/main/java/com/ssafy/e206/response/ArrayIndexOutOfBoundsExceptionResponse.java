package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.Map;

public class ArrayIndexOutOfBoundsExceptionResponse {
    private final Map<String, Object> details;
    private static StackTraceElement[] stackTrace;

    public Map<String, Object> getDetails() {
        return details;
    }

    private ArrayIndexOutOfBoundsExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    private static void setStackTraceElement(StackTraceElement[] stackTrace) {
        ArrayIndexOutOfBoundsExceptionResponse.stackTrace = stackTrace;
    }

    public StackTraceElement[] getStackTrace() {
        return ArrayIndexOutOfBoundsExceptionResponse.stackTrace;
    }

    public static ArrayIndexOutOfBoundsExceptionResponse of(final ArrayIndexOutOfBoundsException e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("errorMessage", e.getMessage() != null ? e.getMessage() : "ArrayIndexOutOfBoundsException");
        map.put("location", new HashMap<String, Object>() {
            {
                put("fileName", e.getStackTrace()[0].getFileName());
                put("className", e.getStackTrace()[0].getClassName());
                put("lineNumber", e.getStackTrace()[0].getLineNumber());
                put("methodName", e.getStackTrace()[0].getMethodName());
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new ArrayIndexOutOfBoundsExceptionResponse(map);
    }

    @Override
    public String toString() {
        return "ArrayIndexOutOfBoundsException [ " + details + " ]";
    }
}
