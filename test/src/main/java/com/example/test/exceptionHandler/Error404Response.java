// package com.example.test.exceptionHandler;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.http.HttpStatus;

// import com.ssafy.e206.response.CommonResponse;

// public class Error404Response implements CommonResponse {

<<<<<<< HEAD
// private String err;
// private int code;
// private Map<String, String> msg;

// public Error404Response(HttpStatus httpStatus, Exception exception) {
// this.err = httpStatus.name();
// this.code = httpStatus.value();
// this.msg = getMsgFromException(exception);
// }

// public Error404Response() {
// }

// private Map<String, String> getMsgFromException(Exception exception) {
// return new HashMap<String, String>() {
// {
// put("msg", exception.getMessage());
// }
// };
// }

// public String getErr() {
// return this.err;
// }

// public void setErr(String err) {
// this.err = err;
// }

// public int getCode() {
// return this.code;
// }

// public void setCode(int code) {
// this.code = code;
// }

// public Map<String, String> getMsg() {
// return this.msg;
// }

// public void setMsg(Map<String, String> msg) {
// this.msg = msg;
// }

// @Override
// public CommonResponse of(HttpStatus httpStatus, Exception exception) {
// return new Error404Response(httpStatus, exception);
// }
=======
//   private String err;
//   private int code;
//   private Map<String, String> msg;

//   public Error404Response(HttpStatus httpStatus, Exception exception) {
//     this.err = httpStatus.name();
//     this.code = httpStatus.value();
//     this.msg = getMsgFromException(exception);
//   }

//   public Error404Response() {
//   }

//   private Map<String, String> getMsgFromException(Exception exception) {
//     return new HashMap<String, String>() {
//       {
//         put("msg", exception.getMessage());
//       }
//     };
//   }

//   public String getErr() {
//     return this.err;
//   }

//   public void setErr(String err) {
//     this.err = err;
//   }

//   public int getCode() {
//     return this.code;
//   }

//   public void setCode(int code) {
//     this.code = code;
//   }

//   public Map<String, String> getMsg() {
//     return this.msg;
//   }

//   public void setMsg(Map<String, String> msg) {
//     this.msg = msg;
//   }

//   @Override
//   public CommonResponse of(HttpStatus httpStatus, Exception exception) {
//     return new Error404Response(httpStatus, exception);
//   }
>>>>>>> d45634bc07a032cbcfe8e8989dcce60fb850d826
// }