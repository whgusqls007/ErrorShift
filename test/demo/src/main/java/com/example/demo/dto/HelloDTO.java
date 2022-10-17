package com.example.demo.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

// String name, int age를 가진 DTO 생성
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HelloDTO {

  @ApiModelProperty(example = "홍길동", value = "이름")
  @NotBlank
  private String name;

  @ApiModelProperty(example = "20", value = "나이")
  @Positive
  @Digits(integer = 2, fraction = 0)
  private int age;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    HelloDTO other = (HelloDTO) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
}
