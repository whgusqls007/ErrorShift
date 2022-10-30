package com.ssafy.e206.configuration;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.annotation.TestAnnotations;
import com.ssafy.e206.response.CommonResponse;
import com.ssafy.e206.response.error4xx.Error404Response;
import com.ssafy.e206.response.error5xx.Error500RuntimeExceptionResponse;

@SuppressWarnings("null")
@Configuration
@ControllerAdvice
public class TestAnnotationsConfig extends BasicErrorController implements ImportAware {
  AnnotationAttributes[] annotationAttributes;
  private final ErrorProperties errorProperties;
  private final ErrorAttributes errorAttributes;

  public TestAnnotationsConfig(
      ErrorAttributes errorAttributes, ServerProperties serverProperties) {
    super(errorAttributes, serverProperties.getError());
    this.errorAttributes = errorAttributes;
    this.errorProperties = serverProperties.getError();
  }

  private void setAnnotationAttributes(AnnotationAttributes[] annotationAttributes) {
    this.annotationAttributes = annotationAttributes;
  }

  @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
  public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
    HttpStatus status = getStatus(request);
    Map<String, Object> model = Collections
        .unmodifiableMap(getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.TEXT_HTML)));
    response.setStatus(status.value());
    ModelAndView modelAndView = resolveErrorView(request, response, status, model);
    System.out.println("123");
    return (modelAndView != null) ? modelAndView : new ModelAndView("error", model);
  }

  @RequestMapping
  public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {

    HttpStatus status = getStatus(request);
    if (status == HttpStatus.NO_CONTENT) {
      return new ResponseEntity<>(status);
    }
    Map<String, Object> body = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.ALL));
    System.out.println(this.errorAttributes.toString());
    System.out.println(this.errorProperties.getIncludeBindingErrors().toString());

    return new ResponseEntity<>(body, status);
  }

  // @ExceptionHandler
  // public Object handleException(Exception exception) {
  // for (AnnotationAttributes annotationAttribute : this.annotationAttributes) {
  // Class<? extends Throwable> exceptionClass =
  // annotationAttribute.getClass("exception");
  // System.out.println(
  // "File: TestAnnotationsConfig.java ~ line: (60) ~ function:
  // ObjecthandleException ---> this.errorAttributes: "
  // + this.errorAttributes);
  // if (exceptionClass.isInstance(exception) &&
  // NoHandlerFoundException.class.isInstance(exception)) {
  // System.out.println("NoHandlerFoundException");
  // String basePackage = annotationAttribute.getString("basePackage");
  // HttpStatus errorCode = annotationAttribute.getEnum("errorCode");
  // System.out.println(basePackage);
  // if (basePackage.equals("")) {
  // return new ResponseEntity<>(Error404Response.of(errorCode, exception),
  // HttpStatus.NOT_FOUND);
  // } else {
  // try {
  // Object obj = Class.forName(basePackage).newInstance();
  // CommonResponse response = ((CommonResponse) obj).of(errorCode, exception);
  // return new ResponseEntity<>(response.of(errorCode, exception), errorCode);
  // } catch (ClassNotFoundException | SecurityException | IllegalAccessException
  // | IllegalArgumentException | InstantiationException e) {
  // e.printStackTrace();
  // return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
  // }
  // }
  // } else if (exceptionClass.isInstance(exception) &&
  // NullPointerException.class.isInstance(exception)) {
  // System.out.println("NullPointerException");
  // String basePackage = annotationAttribute.getString("basePackage");
  // HttpStatus errorCode = annotationAttribute.getEnum("errorCode");
  // if (basePackage.equals("")) {
  // return new ResponseEntity<>(Error500RuntimeExceptionResponse.of(errorCode,
  // exception),
  // errorCode);
  // } else {
  // try {
  // Object obj = Class.forName(basePackage).newInstance();
  // CommonResponse response = ((CommonResponse) obj).of(errorCode, exception);
  // return new ResponseEntity<>(response.of(errorCode, exception), errorCode);
  // } catch (ClassNotFoundException | SecurityException | IllegalAccessException
  // | IllegalArgumentException | InstantiationException e) {
  // e.printStackTrace();
  // return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
  // }
  // }
  // }
  // }
  // return null;
  // }

  private AnnotationAttributes[] getAnnotations(AnnotationMetadata importMetadata) {
    return AnnotationAttributes
        .fromMap(importMetadata.getAnnotationAttributes(TestAnnotations.class.getName()))
        .getAnnotationArray("value");
  }

  @Override
  public void setImportMetadata(AnnotationMetadata importMetadata) {
    System.out.println("중복 선언 O");
    AnnotationAttributes[] annotationAttributes = getAnnotations(importMetadata);
    setAnnotationAttributes(annotationAttributes);
  }

  // private static final String ERROR_INTERNAL_ATTRIBUTE =
  // DefaultErrorAttributes.class.getName() + ".ERROR";

  // @Override
  // public int getOrder() {
  // return Ordered.HIGHEST_PRECEDENCE;
  // }

  // @Override
  // public ModelAndView resolveException(HttpServletRequest request,
  // HttpServletResponse response, Object handler,
  // Exception ex) {
  // storeErrorAttributes(request, ex);
  // return null;
  // }

  // private void storeErrorAttributes(HttpServletRequest request, Exception ex) {
  // request.setAttribute(ERROR_INTERNAL_ATTRIBUTE, ex);
  // }

  // @Override
  // public Map<String, Object> getErrorAttributes(WebRequest webRequest,
  // ErrorAttributeOptions options) {
  // Map<String, Object> errorAttributes = getErrorAttributes(webRequest,
  // options.isIncluded(Include.STACK_TRACE));
  // if (!options.isIncluded(Include.EXCEPTION)) {
  // errorAttributes.remove("exception");
  // }
  // if (!options.isIncluded(Include.STACK_TRACE)) {
  // errorAttributes.remove("trace");
  // }
  // if (!options.isIncluded(Include.MESSAGE) && errorAttributes.get("message") !=
  // null) {
  // errorAttributes.remove("message");
  // }
  // if (!options.isIncluded(Include.BINDING_ERRORS)) {
  // errorAttributes.remove("errors");
  // }

  // this.setErrorAttributes(errorAttributes);

  // return errorAttributes;
  // }

  // private Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean
  // includeStackTrace) {
  // Map<String, Object> errorAttributes = new LinkedHashMap<>();
  // errorAttributes.put("timestamp", new Date());
  // addStatus(errorAttributes, webRequest);
  // addErrorDetails(errorAttributes, webRequest, includeStackTrace);
  // addPath(errorAttributes, webRequest);
  // return errorAttributes;
  // }

  // private void addStatus(Map<String, Object> errorAttributes, RequestAttributes
  // requestAttributes) {
  // Integer status = getAttribute(requestAttributes,
  // RequestDispatcher.ERROR_STATUS_CODE);
  // if (status == null) {
  // errorAttributes.put("status", 999);
  // errorAttributes.put("error", "None");
  // return;
  // }
  // errorAttributes.put("status", status);
  // try {
  // errorAttributes.put("error", HttpStatus.valueOf(status).getReasonPhrase());
  // } catch (Exception ex) {
  // // Unable to obtain a reason
  // errorAttributes.put("error", "Http Status " + status);
  // }
  // }

  // private void addErrorDetails(Map<String, Object> errorAttributes, WebRequest
  // webRequest,
  // boolean includeStackTrace) {
  // Throwable error = getError(webRequest);
  // if (error != null) {
  // while (error instanceof ServletException && error.getCause() != null) {
  // error = error.getCause();
  // }
  // errorAttributes.put("exception", error.getClass().getName());
  // if (includeStackTrace) {
  // addStackTrace(errorAttributes, error);
  // }
  // }
  // addErrorMessage(errorAttributes, webRequest, error);
  // }

  // private void addErrorMessage(Map<String, Object> errorAttributes, WebRequest
  // webRequest, Throwable error) {
  // BindingResult result = extractBindingResult(error);
  // if (result == null) {
  // addExceptionErrorMessage(errorAttributes, webRequest, error);
  // } else {
  // addBindingResultErrorMessage(errorAttributes, result);
  // }
  // }

  // private void addExceptionErrorMessage(Map<String, Object> errorAttributes,
  // WebRequest webRequest, Throwable error) {
  // errorAttributes.put("message", getMessage(webRequest, error));
  // }

  // protected String getMessage(WebRequest webRequest, Throwable error) {
  // Object message = getAttribute(webRequest, RequestDispatcher.ERROR_MESSAGE);
  // if (!ObjectUtils.isEmpty(message)) {
  // return message.toString();
  // }
  // if (error != null && StringUtils.hasLength(error.getMessage())) {
  // return error.getMessage();
  // }
  // return "No message available";
  // }

  // private void addBindingResultErrorMessage(Map<String, Object>
  // errorAttributes, BindingResult result) {
  // errorAttributes.put("message", "Validation failed for object='" +
  // result.getObjectName() + "'. "
  // + "Error count: " + result.getErrorCount());
  // errorAttributes.put("errors", result.getAllErrors());
  // }

  // private BindingResult extractBindingResult(Throwable error) {
  // if (error instanceof BindingResult) {
  // return (BindingResult) error;
  // }
  // return null;
  // }

  // private void addStackTrace(Map<String, Object> errorAttributes, Throwable
  // error) {
  // StringWriter stackTrace = new StringWriter();
  // error.printStackTrace(new PrintWriter(stackTrace));
  // stackTrace.flush();
  // errorAttributes.put("trace", stackTrace.toString());
  // }

  // private void addPath(Map<String, Object> errorAttributes, RequestAttributes
  // requestAttributes) {
  // String path = getAttribute(requestAttributes,
  // RequestDispatcher.ERROR_REQUEST_URI);
  // if (path != null) {
  // errorAttributes.put("path", path);
  // }
  // }

  // @Override
  // public Throwable getError(WebRequest webRequest) {
  // Throwable exception = getAttribute(webRequest, ERROR_INTERNAL_ATTRIBUTE);
  // if (exception == null) {
  // exception = getAttribute(webRequest, RequestDispatcher.ERROR_EXCEPTION);
  // }
  // // store the exception in a well-known attribute to make it available to
  // metrics
  // // instrumentation.
  // webRequest.setAttribute(ErrorAttributes.ERROR_ATTRIBUTE, exception,
  // WebRequest.SCOPE_REQUEST);
  // return exception;
  // }

  // @SuppressWarnings("unchecked")
  // private <T> T getAttribute(RequestAttributes requestAttributes, String name)
  // {
  // return (T) requestAttributes.getAttribute(name,
  // RequestAttributes.SCOPE_REQUEST);
  // }
}
