// package com.ssafy.e206.handler;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// import com.ssafy.e206.errorCode.ErrorCode;
// import com.ssafy.e206.logger.LoggerService;
// import com.ssafy.e206.response.error4xx.Error400Response;
// import com.ssafy.e206.response.error5xx.Error500RuntimeExceptionResponse;

// @Configuration
// @ControllerAdvice
// public class SsafyHandler400 {

// private final LoggerService loggerService;

// public SsafyHandler400(LoggerService loggerService) {
// this.loggerService = loggerService;
// }

// @ExceptionHandler(MethodArgumentNotValidException.class)
// public ResponseEntity<Error400Response>
// handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
// Error400Response error400Response =
// Error400Response.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
// loggerService.log("\n\n" + error400Response.toString());
// return new ResponseEntity<>(error400Response, HttpStatus.BAD_REQUEST);
// }

// @ExceptionHandler(IllegalArgumentException.class)
// public ResponseEntity<Error500RuntimeExceptionResponse>
// handleIllegalArgumentException(IllegalArgumentException e) {
// Error500RuntimeExceptionResponse error500RuntimeExceptionResponse =
// Error500RuntimeExceptionResponse
// .of(ErrorCode.REQUEST_URI_TOO_LONG, e);
// System.out.println("123");
// loggerService.log(error500RuntimeExceptionResponse.toString());
// return new ResponseEntity<>(error500RuntimeExceptionResponse,
// HttpStatus.URI_TOO_LONG);
// }
// }
