package com.bootcamp.demo;

public class DemoThread {

  public static void main(String[] args) {
    int x = 3;
    x++;
    System.out.println(x); // 4

    // Thread
    Runnable task = new PrintHelloWorldTenTimes();

    Thread worker1 = new Thread(task);
    worker1.start();

    Thread worker2 = new Thread(task);
    worker2.start();

    Thread worker3 = new Thread(task);
    worker3.start();

    // We don't know when worker1 and Worker2 come back
    // Worker1 behavior does not depends

    System.out.println("Goodbye");
  }
}
