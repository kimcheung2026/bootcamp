package com.bootcamp.maven.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
  public boolean isEmailExists(String email) {
    String sql = "SELECT COUNT(*) FROM students WHERE email = ?";
    try (Connection conn = DBUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, email);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return rs.getInt(1) > 0; // 如果數量 > 0 代表重複
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  public void insert(Student student) {
    if (isEmailExists(student.getEmail())) {
      System.out.println("拒絕寫入：Email [" + student.getEmail() + "] 已被註冊！");
      return; // 直接結束，不執行 SQL
    }
    String sql = "INSERT INTO students (name, email) VALUES (?, ?)";

    try (Connection conn = DBUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

      stmt.setString(1, student.getName());
      stmt.setString(2, student.getEmail());
      stmt.executeUpdate();
      System.out.println("學生資料已儲存成功！");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<Student> findAll() {
    List<Student> students = new ArrayList<>();
    String sql = "SELECT * FROM students";

    try (Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

      while (rs.next()) {
        // 將資料庫行轉為 Java 物件
        Student s = new Student(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("email"));
        students.add(s);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return students;
  }

  public void updateEmailByName(String name, String newEmail) {
    // 將 SQL 隱藏在 DAO 內部
    String sql = "UPDATE students SET email = ? WHERE name = ?";

    try (Connection conn = DBUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

      stmt.setString(1, newEmail);
      stmt.setString(2, name);

      int rows = stmt.executeUpdate();
      System.out.println("成功更新了 " + rows + " 筆資料");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void deleteById(int id) {
    String sql = "DELETE FROM students WHERE id = ?";

    try (Connection conn = DBUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

      stmt.setInt(1, id);
      int rows = stmt.executeUpdate();
      System.out.println("成功刪除 ID 為 " + id + " 的學生，影響列數: " + rows);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}