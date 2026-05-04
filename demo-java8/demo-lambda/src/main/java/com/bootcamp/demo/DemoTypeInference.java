package com.bootcamp.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DemoTypeInference {
  // ! Wrong Syntax
  // 1. Attribute Type
  // var name;
  // 2. method input param
  // 3. method return type

  public static void main(String[] args) {
    // Java 10 一開始隨機定 但定義後不能改
    var x = 3;
    x = x + 10;
    System.out.println(x); // 13

    var y = "hello";
    System.out.println(y.charAt(0)); // h

    // BigDecimal
    var bd = BigDecimal.valueOf(130);
    // LocalDate
    var ld = LocalDate.of(2026, 1, 1);
    // Dog
    var dog = new Dog();

    // ! Cannot reassign another type of value into the original variable
    // x = 10.3;

    // ! var -> determine the type by value

    Object o = sum(10, 11);
    if (o instanceof Integer) {
      Integer number = (Integer) o;
      System.out.println(number);
    }

    // var
    Map<String, String> map1 = new HashMap<>();
    map1.put("John", "Apple");
    map1.put("Peter", "Banana");

    // for (Map.Entry<String, String> entry : map1.entrySet()) {
    for (var entry : map1.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }

  }

  // public static double sum(var x, var y) {
  // return x + y;
  // }

  // public static var sum(int x, int y) {
  // return x + y;
  // }

  // Return Object Type (Java OK)
  public static Object sum(int x, int y) {
    return x + y;
  }
}