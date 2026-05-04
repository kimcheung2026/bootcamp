package com.bootcamp.demo;

import java.util.ArrayList;
import java.util.List;

public class DemoThread3 {
  private int x;
  private List<String> values;

  public DemoThread3() {
    this.values = new ArrayList<>();
  }

  public void add(int times) {
    for (int i = 0; i < times; i++) {
      this.values.add("abc");
      ;
    }
  }

  public synchronized boolean add(String value) {
    return this.values.add(value);
  }

  public int getSize() {
    return this.values.size();
  }

  public static void main(String[] args) {
    DemoThread3 d = new DemoThread3();

    Runnable add500Task = new Runnable() {
      @Override
      public void run() {
        d.add(1000);
      }
    };

    Thread thread1 = new Thread(add500Task);
    thread1.start();
    Thread thread2 = new Thread(add500Task);
    thread2.start();

    // ! join ()
    try {
      thread1.join(); // throw checked exception
      thread2.join(); // throw checked exception

    } catch (InterruptedException e) {

    }
    System.out.println(d.getSize());
  }

}
