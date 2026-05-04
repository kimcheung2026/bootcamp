package com.bootcamp.demo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Dog implements Comparable<Dog> {
  private int age;
  private String name;

  @Override
  public int compareTo(Dog dog) {
    return this.age > dog.getAge() ? 1 : -1;
  }
}