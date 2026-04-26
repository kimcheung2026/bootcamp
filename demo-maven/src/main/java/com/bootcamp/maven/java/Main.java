package com.bootcamp.maven.java;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 以物件的方式操作
        Student alice = new Student("Alice", "alice@example.com");
        StudentDAO dao = new StudentDAO();

        dao.insert(alice);

        // 2. 查詢並印出結果 (注意 A 要大寫)
        System.out.println("--- 查詢所有學生 ---");
        List<Student> list = dao.findAll();
        for (Student s : list) {
            System.out.println(s); // 這會呼叫 Student 的 toString()
        }

        dao.updateEmailByName("alice", "newemail@example.com");
        for (Student s : list) {
            System.out.println(s);
        }

        dao.deleteById(2);

    }
}