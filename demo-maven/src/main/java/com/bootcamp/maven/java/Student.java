package com.bootcamp.maven.java;

public class Student {
  private int id;
  private String name;
  private String email;

  // for insert
  public Student(String name, String email) {
    this.name = name;
    this.email = email;
  }

  // for finall
  public Student(int id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  // Getter and Setter
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  // Setter (根據需求，ID 可不給 Setter 以防止誤改)
  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return id + ", " + name + ", " + email;
  }

}
