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

    private static void setStackTraceElement(StackTraceElement[] stackTrace) {
        HttpRequestMethodNotSupportedExceptionResponse.stackTrace = stackTrace;
    }

    public StackTraceElement[] getStackTrace() {
        return this.stackTrace;
    }



    public static Map<String, Object> of(final HttpRequestMethodNotSupportedException e) {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("errorMessage", e.getMessage());
        map.put("supMetod", e.getSuppressed());
        map.put("rootCause", e.getRootCause());
        map.put("supportedHttpMethods", e.getSupportedHttpMethods());
        map.put("supportedMethods", e.getSupportedMethods());
        map.put("method", e.getMethod());

        map.put("location", new HashMap<String, Object>(){
            {
                put("fileName", e.getStackTrace()[0].getFileName());
                put("className", e.getStackTrace()[0].getClassName());
                put("lineNumber", e.getStackTrace()[0].getLineNumber());
                put("methodName", e.getStackTrace()[0].getMethodName());
            }
            
        });
        return map;
    }
}
