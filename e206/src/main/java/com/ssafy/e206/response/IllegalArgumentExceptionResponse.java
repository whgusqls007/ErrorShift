package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.Map;

public class IllegalArgumentExceptionResponse {

    String message;
    Throwable[] supportedMethod;

    public IllegalArgumentExceptionResponse(String message, Throwable[] supportedMethod) {
        this.message = message;
        this.supportedMethod = supportedMethod;
    }

    public static Map<String, Object> of(final IllegalArgumentException e) {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("Message", e.getMessage());
        map.put("supMetod", e.getSuppressed());
        map.put("localinitialize", e.getLocalizedMessage());
        map.put("Suppressed", e.getSuppressed());
        map.put("trace !!!", e.getStackTrace());

        return map;

    }

}