package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.HttpRequestMethodNotSupportedException;

public class HttpRequestMethodNotSupportedExceptionResponse {

    String message;
    Throwable[] supportedMethod;

    public HttpRequestMethodNotSupportedExceptionResponse(String message, Throwable[] supportedMethod) {
        this.message = message;
        this.supportedMethod = supportedMethod;
    }

    public static Map<String, Object> of(final HttpRequestMethodNotSupportedException e) {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("errorMessage", e.getMessage());
        map.put("supMetod", e.getSuppressed());
        map.put("rootCause", e.getRootCause());
        map.put("supportedHttpMethods", e.getSupportedHttpMethods());
        map.put("supportedMethods", e.getSupportedMethods());
        map.put("method", e.getMethod());

        return map;
    }
}
