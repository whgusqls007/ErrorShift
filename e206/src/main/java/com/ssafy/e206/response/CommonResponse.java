package com.ssafy.e206.response;

import org.springframework.http.HttpStatus;

public interface CommonResponse {
    public CommonResponse of(HttpStatus httpStatus, Exception exception);
}
