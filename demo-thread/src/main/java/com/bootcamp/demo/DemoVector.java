package com.bootcamp.demo;

import java.util.Vector;

public class DemoVector {

  // ! Java provide native data structure for array list (synchronized)
  // ! Thread-safe (Vector, Stack(pop + push), HashTable)
  // ! Non Thread-safe (ArrayList , Deque, LinkedList , Hashmap)
  private Vector<String> values; // add()

  public DemoVector() {
    this.values = new Vector<>();
  }

  // 補上 add 方法
  public void add(int times) {
    for (int i = 0; i < times; i++) {
      values.add("data"); // Vector.add 是同步的
    }
  }

  // 補上獲取大小的方法
  public int getLength() {
    return this.values.size();
  }

  public static void main(String[] args) {
    DemoVector v = new DemoVector();

    // Class implement Interface
    // Another Approach
    Runnable add1000Task = new Runnable() {
      @Override
      public void run() {
        v.add(1000);
      }
    };

    Thread thread1 = new Thread(add1000Task);
    thread1.start();
    Thread thread2 = new Thread(add1000Task);
    thread2.start();

    // ! join ()
    try {
      thread1.join(); // throw checked exception
      thread2.join(); // throw checked exception

    } catch (InterruptedException e) {

    }
    // 正確獲取 Vector 的大小
    System.out.println("最終大小: " + v.getLength());
  }

}
