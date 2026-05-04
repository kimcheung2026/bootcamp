package com.bootcamp.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//! Write Test Case before main code (TDD - Test Driven Design)
public class CalculatorTest {
  @Test
  void testCalculator() {
    Calculator c1 = new Calculator(7, 8);
    Assertions.assertEquals(15, c1.sum());
    c1.setX(-5);
    Assertions.assertEquals(3, c1.sum());

  }
}
