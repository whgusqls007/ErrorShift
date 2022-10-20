package com.ssafy.e206.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public void log(String message) {
    logger.error(message);
  }

}
