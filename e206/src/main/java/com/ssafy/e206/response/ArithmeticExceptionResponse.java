package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticExceptionResponse {
    private Map<String, Object> details;

    public Map<String, Object> getDetails() {
        return details;
    }

    private ArithmeticExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    public static ArithmeticExceptionResponse of(final ArithmeticException e) {
        System.out.println("ArithmeticExceptionResponse of() called");
        HashMap<String, Object> map = new HashMap<>();
        map.put("Message", e.getMessage());

        map.put("FileName", e.getStackTrace()[0].getFileName());
        map.put("ClassName", e.getStackTrace()[0].getClassName());
        map.put("LineNumber", e.getStackTrace()[0].getLineNumber());
        map.put("MethodName", e.getStackTrace()[0].getMethodName());

        map.put("StackTrace", e.getStackTrace());
        System.out.println("map: "+map.toString());
        return new ArithmeticExceptionResponse(map);
    }
}
