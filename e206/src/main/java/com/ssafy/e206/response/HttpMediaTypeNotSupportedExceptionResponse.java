package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.HttpMediaTypeNotSupportedException;

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
        return this.stackTrace;
    }

    private HttpMediaTypeNotSupportedExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    public static HttpMediaTypeNotSupportedExceptionResponse of(final HttpMediaTypeNotSupportedException e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("errorMessage", e.getMessage());

        if (e.getContentType() != null) {
            map.put("contentType", e.getContentType());
        }
        map.put("supportedMediaTypes", e.getSupportedMediaTypes());
        map.put("location", new HashMap<String, Object>() {
            {
                put("fileName", e.getStackTrace()[0].getFileName());
                put("className", e.getStackTrace()[0].getClassName());
                put("lineNumber", e.getStackTrace()[0].getLineNumber());
                put("methodName", e.getStackTrace()[0].getMethodName());
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new HttpMediaTypeNotSupportedExceptionResponse(map);
    }
}
