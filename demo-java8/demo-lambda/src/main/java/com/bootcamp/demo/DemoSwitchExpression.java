package com.bootcamp.demo;

public class DemoSwitchExpression {
  public static enum Color {
    RED, BLUE, BLACK;
  }

  public static void main(String[] args) {
    // Java 14 (Lambda -> Switch)
    Color color = Color.BLUE;

    // switch
    switch (color) { // switch -> null -> throw NPE
      case RED:
        System.out.println("It is red.");
        break;
      case BLUE:
        System.out.println("It is blue.");
        break;
      case BLACK:
        System.out.println("It is BLACK.");
        break;
      default:
        System.out.println("Default");
        break;
    }

    // Switch Expression
    switch (color) {
      case RED -> System.out.println("It is red.");
      case BLUE -> System.out.println("It is blue.");
      case BLACK -> System.out.println("It is black.");
    }

    // with return version
    // ! Check all possible values in enum has been written down (otherwise, syntax
    // error)
    String result = switch (color) {
      case RED -> {
        System.out.println("it is red"); // 100 lines
        yield "RED.";
      }
      case BLUE -> {
        System.out.println("it is red");
        yield "BLUE.";
      }
      case BLACK -> {
        System.out.println("it is red");
        yield "BLACK.";
      }
    };
    System.out.println(result); // BLUE.

  }
}