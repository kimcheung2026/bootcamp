package com.bootcamp.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class DemoOptional {
  // ! Wrong usage:
  // 1. Attribute Type
  private Optional<String> name; // Database don't know what Optional is.

  private static List<Dog> dogDatabase = new ArrayList<>(List.of(new Dog("John", 4), new Dog("Peter", 5)));

  public static void main(String[] args) {
    // Java 8: Optional
    // ! The Only Usage of "Optional" is "Return Type" of method
    // ! Manage the method caller and method author

    String inputName = null;
    try {
      Optional<Dog> result = searchDog(inputName);
      if (result.isPresent()) {
        System.out.println(result.get());
      } else {
        System.out.println("Not Found.");
      }
    } catch (SearchNotFoundException e) {
      System.out.println("Input Name cannot be empty.");
    }

    inputName = "Peter";
    try {
      Optional<Dog> result = searchDog3(inputName);
      if (result.isPresent()) {
        System.out.println(result.get());
      } else {
        System.out.println("Not Found.");
      }
    } catch (SearchNotFoundException e) {
      System.out.println("Input Name cannot be empty.");
    }
  }

  @AllArgsConstructor
  @Getter
  @ToString
  public static class Dog {
    private String name;
    private int age;
  }

  // ! Purpose of Optional:
  // Best Practice: We never return null for any scenario.
  public static Optional<Dog> searchDog(String dogName) {
    if (dogName == null)
      throw new SearchNotFoundException("Dog Name cannot be null.");
    for (Dog dog : dogDatabase) {
      if (dogName.equals(dog.getName())) {
        return Optional.of(dog);
      }
    }
    return Optional.empty(); // new Optional(null);
  }

  // ! Unchecked
  public static class SearchNotFoundException extends RuntimeException {
    public SearchNotFoundException(String message) {
      super(message);
    }
  }

  // ! Wrong usage:
  // 2. Method Input Parameter (Create meaningless coding)
  public static Optional<Dog> searchDog2(Optional<String> dogName) {
    if (dogName == null) {
      throw new IllegalArgumentException();
    }
    String inputName = null;
    if (dogName.isPresent()) {
      inputName = dogName.get();
    }
    if (inputName == null)
      throw new SearchNotFoundException("Dog Name cannot be null.");
    for (Dog dog : dogDatabase) {
      if (inputName.equals(dog.getName())) {
        return Optional.of(dog);
      }
    }
    return Optional.empty(); // new Optional(null);
  }

  // Stream
  // Method: findFirst findAny
  public static Optional<Dog> searchDog3(String dogName) {
    if (dogName == null)
      throw new SearchNotFoundException("Dog Name should not be null.");
    return dogDatabase.stream() //
        .filter(e -> dogName.equals(e.getName())) //
        .sorted((d1, d2) -> d1.getAge() > d2.getAge() ? -1 : 1) //
        .findFirst();
  }
}