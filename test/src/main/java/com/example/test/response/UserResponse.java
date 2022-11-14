package com.example.test.response;

import java.util.HashMap;
import java.util.Map;

import com.ssafy.e206.response.CommonResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements CommonResponse {

  public Map<String, Object> details;
  public StackTraceElement[] stackTrace;

  UserResponse(HashMap<String, Object> map) {
    this.details = map;
  }

  @Override
  public CommonResponse of(Exception e) {
    ArithmeticException arithmeticException = (ArithmeticException) e;
    HashMap<String, Object> map = new HashMap<>();
    map.put("이런", "결과값이 나왔어요");
    setStackTrace(arithmeticException.getStackTrace());
    return new UserResponse(map);
  }
}
