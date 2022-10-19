package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.HelloDTO;

@Service
@SuppressWarnings("null")
public class HelloService {

  public String getName(String name) {

    HelloDTO helloDTO = null;
    helloDTO.getName();

    return "Hello " + name + "!";
  }

}
