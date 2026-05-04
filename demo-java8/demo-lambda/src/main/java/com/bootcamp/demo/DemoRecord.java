package com.bootcamp.demo;

// ! Java 16 Record
// 1. All args constructor (No empty constructor)
// 2. Attributes (private and final)
// 3. getter (No setter)
// 4. toString
// 5. equals and hashCode
public class DemoRecord {
  public static void main(String[] args) {
    Transaction t1 = new Transaction("FUND_TRAN", 100);

    System.out.println(t1.type()); // FUND_TRAN
    System.out.println(t1.amount()); // 100.0

    Transaction t2 = new Transaction("FUND_TRAN", 100);

    System.out.println(t1.equals(t2)); // true
    System.out.println(t1.hashCode() == t2.hashCode()); // true
    System.out.println(t1); // Transaction[type=FUND_TRAN, amount=100.0]

    System.out.println(Transaction.PI);
  }
}