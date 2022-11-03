// package com.ssafy.e206.controller;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// @Controller
// @ControllerAdvice
// public class IllegalArgueController {

//     @ExceptionHandler(IllegalArgumentException.class)
//     public ResponseEntity<ErrorResponse> handleIllegalArgumetnException(IllegalArgumetnException e){
//         log.error("handleIllegalArgumetnException",ex);
//         ErrorResponse response = new ErrorResponse(ex.getErrorCode());
//         return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
//     }


// }