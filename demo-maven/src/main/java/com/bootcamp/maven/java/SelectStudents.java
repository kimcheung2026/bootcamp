package com.bootcamp.maven.java;

import java.util.List;

public class SelectStudents {
  public static void main(String[] args) {
    StudentDAO dao = new StudentDAO();

    // 呼叫物件的方法獲取結果
    List<Student> list = dao.findAll();

    // 遍歷物件清單
    list.forEach(System.out::println);
  }
}
