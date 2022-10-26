// package com.ssafy.e206.response.error4xx;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.web.servlet.NoHandlerFoundException;

// import com.ssafy.e206.errorCode.ErrorCode;
// import com.ssafy.e206.response.ErrorResponse;

// public class Error404Response extends ErrorResponse {
// private Map<String, String> errors;

// public Map<String, String> getErrors() {
// return this.errors;
// }

// private Error404Response(final ErrorCode code, final Map<String, String> map)
// {
// super(code.getMessage(), code.getStatus());
// this.errors = map;
// }

// private Error404Response() {
// }

// public static Error404Response of(final ErrorCode code, final
// NoHandlerFoundException e) {
// return new Error404Response(code, FieldError.of(e));
// }

// public static class FieldError {
// private static Map<String, String> of(final NoHandlerFoundException e) {
// return new HashMap<String, String>() {
// {
// put("requestURL", e.getRequestURL());
// put("method", e.getHttpMethod());
// put("possibleSolution",
// "Your request URL is " + e.getRequestURL() + " . You can check the request
// URL and try again.");
// }
// };
// }
// }

// @Override
// public String toString() {
// return "{" +
// " message='" + getMessage() + "'" +
// ", status='" + getStatus() + "'" +
// ", errors='" + getErrors() + "'" +
// "}";
// }
// }