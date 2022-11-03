package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;

public class IllegalArgumentExceptionResponse {
    
    // Map<String, String> error;
    String message;
    // String status;
    Throwable[] supportedMethod;
    

    public IllegalArgumentExceptionResponse(String message,Throwable[] supportedMethod){
        this.message = message;
        this.supportedMethod = supportedMethod;
    }

    public static Map<String, Object> of(final IllegalArgumentException e){
        
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("Message", e.getMessage());
        map.put("supMetod", e.getSuppressed());
        map.put("localinitialize" , e.getLocalizedMessage());
        map.put("Suppressed", e.getSuppressed());
        map.put("trace !!!", e.getStackTrace());
        // map.put("rootCause", e.getRootCause());
        // map.put("supportedHttpMethods", e.getSupportedHttpMethods());
        // map.put("supportedMethods", e.getSupportedMethods());
        // map.put("Method", e.getMethod());
        // map.put
        // map.put("trace", e.getStackTrace());
        // e.get
        
        return map;
        
    }
    
}
 