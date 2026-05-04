package com.bootcamp.demo;

// ! Java 16
public record Transaction(String type, double amount) {
  public static final double PI = 3.14159;

  // static method OK
}