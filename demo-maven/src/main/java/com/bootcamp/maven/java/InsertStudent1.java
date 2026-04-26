package com.bootcamp.maven.java;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertStudent1 {
  public static void main(String[] args) {
    try (Connection conn = DBUtil.getConnection()) {
      String sql = "INSERT INTO students (name, email) VALUES (?,?)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, "Alice");
      stmt.setString(2, "alice@example.com");
      int rows = stmt.executeUpdate();
      System.out.println("Inserted: " + rows);
    } catch (Exception e) {
      e.printStackTrace();

    }
  }

}
