package com.ssafy.e206.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.ssafy.e206.configuration.ErrorShiftAttributes;
import com.ssafy.e206.controller.ErrorShiftController;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({ ErrorShiftAttributes.class, ErrorShiftController.class })
@ControllerAdvice
public @interface ErrorShifts {
  ErrorShift[] value();
}
