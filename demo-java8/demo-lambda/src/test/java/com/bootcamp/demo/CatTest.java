package com.bootcamp.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//Test Environment

@ExtendWith(MockitoExtension.class)
class CatTest {
  @Mock
  private Dog dog;

  

  @Test
  void testCat() {
    // Constructor, getter,setter
    Cat c1 = new Cat("John");
    Assertions.assertEquals("John", c1.getName());

  }
}
