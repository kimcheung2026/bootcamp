package com.bootcamp.demo;

import lombok.Setter;

@Setter
public class Calculator {
  private int x;
  private int y;

  public Calculator(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int sum() {
    return this.x + this.y; // placeholder
  }

}
