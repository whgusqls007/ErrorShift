package com.ssafy.e206.response;

import java.util.Map;

public interface CommonResponse {
    public CommonResponse of(Exception e);

    public Map<String, Object> getDetails();

    public StackTraceElement[] getStackTrace();
}
