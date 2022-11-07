package com.ssafy.e206.response;

import org.springframework.beans.TypeMismatchException;

import java.util.HashMap;
import java.util.Map;

public class TypeMismatchExceptionResponse {
    private Map<String, Object> details;

    public Map<String, Object> getDetails() {
        return details;
    }

    private TypeMismatchExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    public static TypeMismatchExceptionResponse of(final TypeMismatchException e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("errorMessage", e.getMessage());
        map.put("requiredType", e.getRequiredType());
        map.put("value", e.getValue());
        map.put("propertyName", e.getPropertyName());
        map.put("errorCode", e.getErrorCode());
        map.put("location", new HashMap<String, Object>() {
            {
                put("fileName", e.getStackTrace()[0].getFileName());
                put("className", e.getStackTrace()[0].getClassName());
                put("lineNumber", e.getStackTrace()[0].getLineNumber());
                put("methodName", e.getStackTrace()[0].getMethodName());
            }
        });
        map.put("stackTrace", e.getStackTrace());
        return new TypeMismatchExceptionResponse(map);
    }
}
