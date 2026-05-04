package com.bootcamp.demo;

import java.math.BigDecimal;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

// Serverless
// AWS Lambda (upload jar) -> run Java Application

// Java Lambda
public class DemoLambda {
  public static void main(String[] args) {
    // Function (y = f(x))
    // One Input -> One Output

    // Integer methodName(String s)

    // Functional Interface (One abstract method only) -> Lambda Pattern
    // ! stringLengthFunction is a local variable
    Function<String, Integer> stringLengthFunction = s -> s.length(); // Similar to JavaScript
    System.out.println(stringLengthFunction.apply("hello")); // 5
    System.out.println(stringLengthFunction.apply("Java")); // 4

    Flyable superman = () -> System.out.println("Superman is flying...");
    superman.fly();

    // BiFunction
    // 2 Input -> 1 output
    BiFunction<String, String, Integer> stringLengthFunction2 = (s1, s2) -> s1.length() + s2.length();
    System.out.println(stringLengthFunction2.apply("Python", "Java")); // 10

    // ! Custom Functional Interface
    TriFunction<Integer, Integer, Integer, Integer> sumIntegerFormula = (i1, i2, i3) -> i1 + i2 + i3;
    System.out.println(sumIntegerFormula.apply(10, 20, 30)); // 60

    // Predicate
    // One input -> Boolean
    // Testing
    int age = 67;
    Predicate<Integer> isElderlyFunction = a -> a > 65;
    System.out.println(isElderlyFunction.test(age)); // true
    System.out.println(isElderlyFunction.test(64)); // false

    // BiPredicate
    BiPredicate<String, String> equalsFunction = (s1, s2) -> s1 != null && s1.equals(s2);

    System.out.println(equalsFunction.test("Hello", "Hello")); // true
    System.out.println(equalsFunction.test("Hello", "hello")); // false
    System.out.println(equalsFunction.test(null, "hello")); // false

    // Supplier (No input -> One Output)
    Supplier<Integer> randomMarksixFunction = () -> new Random().nextInt(49) + 1; // 1-49
    System.out.println(randomMarksixFunction.get());
    System.out.println(randomMarksixFunction.get());

    // Consumer (One input -> void)
    Consumer<String> printString = s -> System.out.println(s);
    printString.accept("hello");

    // ! Same as Function<String, String>
    UnaryOperator<String> upperString = s -> s.toUpperCase();
    System.out.println(upperString.apply("Hello")); // HELLO

    // ! Same as BiFunction<String, String, String>
    // ! More than 1 line -> {}, return
    BinaryOperator<String> concatString = (s1, s2) -> {
      if (s1 == null)
        return null;
      return s1.concat(s2);
    };
    System.out.println(concatString.apply("hello", "apple")); // helloapple

    // MathOperation
    MathOperation<Integer, Integer, Integer> sumOperation = (i1, i2) -> i1 + i2;
    System.out.println(sumOperation.compute(7, 9)); // 16

    MathOperation<Integer, Integer, Integer> subtractOperation = (i1, i2) -> i1 - i2;
    System.out.println(subtractOperation.compute(7, 9)); // -2

    MathOperation<Double, Double, Double> sumDoubleOperation = (d1, d2) -> BigDecimal.valueOf(d1) //
        .add(BigDecimal.valueOf(d2)) //
        .doubleValue(); // return Primitive -> autobox

    System.out.println(sumDoubleOperation.compute(0.1, 0.2)); // 0.3
  }

  // ! method -> reusable
  public static Integer getLength(String s) {
    return s.length();
  }