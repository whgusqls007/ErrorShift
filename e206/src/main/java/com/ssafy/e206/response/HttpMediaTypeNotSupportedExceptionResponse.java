package com.ssafy.e206.response;

import org.springframework.web.HttpMediaTypeNotSupportedException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class HttpMediaTypeNotSupportedExceptionResponse {
    private Map<String, Object> details;

    public Map<String, Object> getDetails() {
        return details;
    }

    private HttpMediaTypeNotSupportedExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    public static HttpMediaTypeNotSupportedExceptionResponse of(final HttpMediaTypeNotSupportedException e) {
        System.out.println("HttpMediaTypeNotSupportedExceptionResponse of() called");

        HashMap<String, Object> map = new HashMap<>();
        map.put("Message", e.getMessage());

        if (e.getContentType()!=null) {
            map.put("contentType", e.getContentType());
//            map.put("contentType", e.getContentType().getType()+"/"+e.getContentType().getSubtype());
        }
        map.put("supportedMediaTypes", e.getSupportedMediaTypes());
//        map.put("supportedMediaTypes", e.getSupportedMediaTypes().get(0).getType()+"/"+e.getSupportedMediaTypes().get(0).getSubtype());

        map.put("FileName", e.getStackTrace()[0].getFileName());
        map.put("ClassName", e.getStackTrace()[0].getClassName());
        map.put("LineNumber", e.getStackTrace()[0].getLineNumber());
        map.put("MethodName", e.getStackTrace()[0].getMethodName());

        map.put("StackTrace", e.getStackTrace());
        System.out.println("map: "+map.toString());
        return new HttpMediaTypeNotSupportedExceptionResponse(map);
    }
}
