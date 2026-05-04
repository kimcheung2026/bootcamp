package com.bootcamp.demo;

public class PrintHelloWorldTenTimes implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println("HelloWorld " + i);
    }
  }

}
