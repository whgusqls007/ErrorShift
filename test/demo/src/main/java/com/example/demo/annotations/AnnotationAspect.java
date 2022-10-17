// package com.example.demo.annotations;

// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Component;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// import com.example.demo.exceptionHandler.ErrorCode;
// import com.example.demo.exceptionHandler.ErrorResponse;

// @Aspect
// @Component
// @ControllerAdvice
// public class AnnotationAspect {

// @Around("@annotation(com.example.demo.annotations.MyAnnotation)")
// public Object authorize(ProceedingJoinPoint joinPoint) throws Throwable {
// System.out.println("123123123");
// return null;
// }
// }
