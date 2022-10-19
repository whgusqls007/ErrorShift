package com.example.demo2.configuration;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import com.example.demo2.annotation.EnableSsafyHandler;
import com.example.demo2.handler.SsafyHandlerAll;
import com.example.demo2.handler.SsafyHandler400;
import com.example.demo2.handler.SsafyHandler404;
import com.example.demo2.handler.SsafyHandler500;

@SuppressWarnings("null")
public class EnableSsafyHandlerSelector implements ImportSelector {

  private String[] getAnnotationValues(AnnotationMetadata importingClassMetadata) {
    return AnnotationAttributes
        .fromMap(importingClassMetadata.getAnnotationAttributes(EnableSsafyHandler.class.getName()))
        .getStringArray("value");
  }

  private String[] getHandlerClasses(String[] values) {
    String[] handlerClasses = null;

    if (values.length == 0 || values == null) {
      handlerClasses = new String[] { SsafyHandlerAll.class.getName() };
    } else {
      handlerClasses = new String[values.length];
      for (int i = 0; i < values.length; i++) {
        switch (values[i]) {
          case "400":
            handlerClasses[i] = SsafyHandler400.class.getName();
            break;
          case "404":
            handlerClasses[i] = SsafyHandler404.class.getName();
            break;
          case "500":
            handlerClasses[i] = SsafyHandler500.class.getName();
            break;
        }
      }
    }

    return handlerClasses;
  }

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return getHandlerClasses(getAnnotationValues(importingClassMetadata));
  }
}
