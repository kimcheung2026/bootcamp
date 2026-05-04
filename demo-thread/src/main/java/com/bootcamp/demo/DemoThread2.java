package com.bootcamp.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class DemoThread2 {
  // solution1
  private int x;
  // solution2
  private AtomicInteger y;

  public DemoThread2() {
    this.y = new AtomicInteger(0);
  }

  public void add(int times) {
    for (int i = 0; i < times; i++) {
      // this.x++; // 2 actions (read + write), non-atomic
      this.addOne();
    }
  }

  public int getY() {
    return this.y.get();
  }

  // ! lock the method
  public synchronized void addOne() {
    this.x++;
  }

  public int getX() {
    return this.x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public static void main(String[] args) {
    DemoThread2 d = new DemoThread2();

    // Class implement Interface
    // Another Approach
    Runnable add100Task = new Runnable() {
      @Override
      public void run() {
        d.add(200000);
      }
    };

    Thread thread1 = new Thread(add100Task);
    thread1.start();
    Thread thread2 = new Thread(add100Task);
    thread2.start();

    // ! join ()
    try {
      thread1.join(); // throw checked exception
      thread2.join(); // throw checked exception

    } catch (InterruptedException e) {

    }
    System.out.println(d.getX());
  }

}