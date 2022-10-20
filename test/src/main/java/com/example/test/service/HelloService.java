package com.example.test.service;

import org.springframework.stereotype.Service;

import com.example.test.dto.HelloDTO;

@Service
@SuppressWarnings("null")
public class HelloService {

  public String getName(String name) {

    HelloDTO helloDTO = null;
    helloDTO.getName();

    return "Hello " + name + "!";
  }

}
