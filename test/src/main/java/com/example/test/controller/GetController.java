package com.example.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.dto.HelloDTO;
import com.example.test.service.HelloService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = { "hello" })
@RequestMapping("/api/v1/get-api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GetController {

  @Autowired
  public HelloService helloService;

  /**
   * todo: getMapping, getName() 함수, @PathVariabl을 사용해서 '/{name}' 로 요청이 들어오면
   * 'Hello {name}!' 를 반환합니다.
   * 
   * @param @PathVariable @name
   * @return 'Hello {name}!'
   */

  @ApiOperation(value = "닫혔을 때 설명", notes = "열었을 때 설명")
  @GetMapping("/{name}")
  public String getName(@PathVariable String name) {
    HelloDTO helloDTO = new HelloDTO();
    helloDTO.setName(name);
    System.out.println(" helloDTO: " + helloDTO);
    for (int i = 0; i < 50000; i++) {
      System.out.println(i);
    }
    return "Hello " + name + "!";
  }

  /**
   * todo: get으로 helloDto 객체를 받아서 ResponseEntity(HelloDto)를 반환.
   * 
   * @param helloDTO
   * @return ResponseEntity.ok(helloDto)
   */
  @ApiOperation(value = "get DTO 사용", notes = "DTO 객체 swagger 설정 테스트")
  @GetMapping("/hellodto")
  @Valid
  public ResponseEntity<HelloDTO> getHelloDto(HelloDTO helloDto) {
    System.out.println("helloDto: " + helloDto);
    return ResponseEntity.ok(helloDto);
  }

  /**
   * todo: post로 helloDto 객체를 받아서 ResponseEntity(HelloDto)를 반환.
   * 
   * @param helloDTO
   * @return ResponseEntity.ok(helloDto)
   */
  @ApiOperation(value = "post DTO 사용", notes = "DTO 객체 swagger 설정 테스트")
  @PostMapping("/hellodto")
  @ResponseBody
  public ResponseEntity<HelloDTO> postHelloDto(@RequestBody @ApiParam(value = "이름과 나이") @Valid HelloDTO helloDto) {
    System.out.println("helloDto: " + helloDto);
    return ResponseEntity.ok(helloDto);
  }

  @GetMapping("/test")
  @ResponseBody
  public ResponseEntity<String> test() {
    return ResponseEntity.ok(helloService.getName("test"));
  }

  @DeleteMapping("/test")
  @ResponseBody
  public ResponseEntity<String> testDelete() {
    return ResponseEntity.ok(helloService.getName("test"));
  }

  @GetMapping("/indexOutOfBoundsException")
  public ResponseEntity<String> indexOutOfBoundsException() {
    return ResponseEntity.ok(helloService.indexError());
  }

  @GetMapping("/URI-Too-Long/{name}")
  public ResponseEntity<String> uriTooLong(@PathVariable String name) {
    return ResponseEntity.status(HttpStatus.URI_TOO_LONG).body("URI Too Long");
  }
}
