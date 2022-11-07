package com.ssafy.e206.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.NoHandlerFoundException;

public class NoHandlerFoundExceptionResponse {
    

    public static Map<String, Object> of(final NoHandlerFoundException e){
        
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("RequestURL", e.getRequestURL());
        map.put("HttpMethod", e.getHttpMethod());
        map.put("Message", e.getMessage());
        map.put("Header", e.getHeaders());
        map.put("starTrace", e.getStackTrace());
        return map;
        
    }
}
