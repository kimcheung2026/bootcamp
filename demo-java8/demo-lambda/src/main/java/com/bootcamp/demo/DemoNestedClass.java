
package com.bootcamp.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DemoNestedClass {
  private static final String NAME = "Jenny";

  // Inner Class, Static nested Class
  private int x;

  // ! Inner Class
  @AllArgsConstructor
  @Getter
  public class Ball {
    private int z;

    public int getValue() {
      return this.z + x; // ! Inner class CAN access the outer class data.
    }
  }

  // ! Static nested Class
  @AllArgsConstructor
  @Getter
  public static class NestedClass {
    private int y;

    public int getValue() {
      // return this.y + x; // ! Static nested class CANNOT access the outer class
      // data.
      System.out.println(DemoNestedClass.NAME); // Jenny
      return this.y;
    }
  }

  public static void main(String[] args) {
    NestedClass nc = new NestedClass(10);

    // ! Create inner class object
    Ball b1 = new DemoNestedClass(20).new Ball(10); // ! DemoNestedClass Object still exist in memory?
    System.out.println(b1.getValue()); // 30

    DemoNestedClass nc2 = new DemoNestedClass(30);
    Ball b2 = nc2.new Ball(100);

    // ! No need to create Class to implement Action
    Action action = new Action() {
      @Override
      public void read() {
        System.out.println("I am reading...");
      }

      @Override
      public void run() {
        System.out.println("I am reading...");
      }
    };
    action.read();
    action.run();
  }

  // ! Local Inner Class
  // A Class inside the method
  public void methodWithLocalInner() {
    int localVar = 5;

    class LocalInner {
      int x;

      void display() {
        System.out.println("Local Inner Class: " + localVar + this.x);
      }
    }

    LocalInner localInner = new LocalInner();
    localInner.display();

    // interface Display {
    // void display();
    // }

    // Display d1 = () -> System.out.println("Hello World");
    // d1.display();
  }

  // ! Anonymous Inner Class
  interface Action {
    void read();

    void run();
  }
}