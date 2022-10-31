package com.ssafy.e206.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.e206.configuration.CustomErrorAttributes;

public abstract class CustomAbstractErrorController implements ErrorController {
  private final CustomErrorAttributes errorAttributes;

  private final List<ErrorViewResolver> errorViewResolvers;

  public CustomAbstractErrorController(CustomErrorAttributes errorAttributes) {
    this(errorAttributes, null);
  }

  public CustomAbstractErrorController(CustomErrorAttributes errorAttributes,
      List<ErrorViewResolver> errorViewResolvers) {
    Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
    this.errorAttributes = errorAttributes;
    this.errorViewResolvers = sortErrorViewResolvers(errorViewResolvers);
  }

  private List<ErrorViewResolver> sortErrorViewResolvers(List<ErrorViewResolver> resolvers) {
    List<ErrorViewResolver> sorted = new ArrayList<>();
    if (resolvers != null) {
      sorted.addAll(resolvers);
      AnnotationAwareOrderComparator.sortIfNecessary(sorted);
    }
    return sorted;
  }

  protected Map<String, Object> getErrorAttributes(HttpServletRequest request, ErrorAttributeOptions options) {
    WebRequest webRequest = new ServletWebRequest(request);
    return this.errorAttributes.getErrorAttributes(webRequest, options);
  }

  protected boolean getTraceParameter(HttpServletRequest request) {
    return getBooleanParameter(request, "trace");
  }

  protected boolean getMessageParameter(HttpServletRequest request) {
    return getBooleanParameter(request, "message");
  }

  protected boolean getErrorsParameter(HttpServletRequest request) {
    return getBooleanParameter(request, "errors");
  }

  protected boolean getBooleanParameter(HttpServletRequest request, String parameterName) {
    String parameter = request.getParameter(parameterName);
    if (parameter == null) {
      return false;
    }
    return !"false".equalsIgnoreCase(parameter);
  }

  protected HttpStatus getStatus(HttpServletRequest request) {
    Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    if (statusCode == null) {
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    try {
      return HttpStatus.valueOf(statusCode);
    } catch (Exception ex) {
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }
  }

  protected ModelAndView resolveErrorView(HttpServletRequest request, HttpServletResponse response, HttpStatus status,
      Map<String, Object> model) {
    for (ErrorViewResolver resolver : this.errorViewResolvers) {
      ModelAndView modelAndView = resolver.resolveErrorView(request, status, model);
      if (modelAndView != null) {
        return modelAndView;
      }
    }
    return null;
  }
}
