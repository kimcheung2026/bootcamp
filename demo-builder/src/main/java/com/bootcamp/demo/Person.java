package com.bootcamp.demo;

import java.util.Objects;

//! Code Pattern (Builder Pattern)
public class Person {
  private String name;
  private int age;

  public Person() {

  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Person))
      return false;
    Person other = (Person) o;
    if (this.name == null ? other.name != null : !this.name.equals(other.name))
      return false;
    if (this.age != other.age)
      return false;
    return true;
    // return Object.equals(person.getName(),this.name) &&
    // Objects.equals(person.getAge(),this.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.age);
  }

  @Override
  public String toString() {
    return "Person(name=" + this.name + ", age=" + this.age + ")";
  }

  public static void main(String[] args) {
    Person p1 = new Person("John", 20);

  }
}
