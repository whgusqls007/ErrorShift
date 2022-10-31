package com.ssafy.e206.configuration;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomBasicErrorController extends CustomAbstractErrorController implements ImportAware {
  private ErrorProperties errorProperties;

  public CustomBasicErrorController(CustomErrorAttributes errorAttributes, ErrorProperties errorProperties,
      List<ErrorViewResolver> errorViewResolvers) {
    super(errorAttributes, errorViewResolvers);
    System.out.println(errorAttributes);
    Assert.notNull(errorProperties, "ErrorProperties must not be null");
    this.errorProperties = errorProperties;
  }

  @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
  public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
    HttpStatus status = getStatus(request);
    Map<String, Object> model = Collections
        .unmodifiableMap(getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.TEXT_HTML)));
    response.setStatus(status.value());
    ModelAndView modelAndView = resolveErrorView(request, response, status, model);
    return (modelAndView != null) ? modelAndView : new ModelAndView("error", model);
  }

  @RequestMapping
  public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
    HttpStatus status = getStatus(request);
    if (status == HttpStatus.NO_CONTENT) {
      return new ResponseEntity<>(status);
    }
    Map<String, Object> body = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.ALL));
    System.out.println("1231231232");

    return new ResponseEntity<>(body, status);
  }

  @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
  public ResponseEntity<String> mediaTypeNotAcceptable(HttpServletRequest request) {
    HttpStatus status = getStatus(request);
    return ResponseEntity.status(status).build();
  }

  protected ErrorAttributeOptions getErrorAttributeOptions(HttpServletRequest request, MediaType mediaType) {
    ErrorAttributeOptions options = ErrorAttributeOptions.defaults();
    if (this.errorProperties.isIncludeException()) {
      options = options.including(Include.EXCEPTION);
    }
    if (isIncludeStackTrace(request, mediaType)) {
      options = options.including(Include.STACK_TRACE);
    }
    if (isIncludeMessage(request, mediaType)) {
      options = options.including(Include.MESSAGE);
    }
    if (isIncludeBindingErrors(request, mediaType)) {
      options = options.including(Include.BINDING_ERRORS);
    }
    return options;
  }

  protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
    switch (getErrorProperties().getIncludeStacktrace()) {
      case ALWAYS:
        return true;
      case ON_PARAM:
        return getTraceParameter(request);
      default:
        return false;
    }
  }

  protected boolean isIncludeMessage(HttpServletRequest request, MediaType produces) {
    switch (getErrorProperties().getIncludeMessage()) {
      case ALWAYS:
        return true;
      case ON_PARAM:
        return getMessageParameter(request);
      default:
        return false;
    }
  }

  protected boolean isIncludeBindingErrors(HttpServletRequest request, MediaType produces) {
    switch (getErrorProperties().getIncludeBindingErrors()) {
      case ALWAYS:
        return true;
      case ON_PARAM:
        return getErrorsParameter(request);
      default:
        return false;
    }
  }

  protected ErrorProperties getErrorProperties() {
    return this.errorProperties;
  }

  @Override
  public void setImportMetadata(AnnotationMetadata importMetadata) {
    // TODO Auto-generated method stub
  }

}
