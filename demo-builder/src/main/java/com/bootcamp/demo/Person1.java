package com.bootcamp.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder

public class Person1 {
  private String name;
  private int age;

  public static void main(String[] args) {
    Person1 p1 = Person1.builder()//
        .name("John")
        .age(20)//
        .build();
    System.out.println(p1.getAge());
    System.out.println(p1.getName());

  }
}
