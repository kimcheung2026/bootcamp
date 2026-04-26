package com.bootcamp.maven.java;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateStudent1 {
  public static void main(String[] args) {
    try (Connection conn = DBUtil.getConnection()) {
      String sql = "UPDATE students SET email = ? WHERE name = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, "newemail@example.com");
      stmt.setString(2, "Alice");
      int rows = stmt.executeUpdate();
      System.out.println("Updated: " + rows);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
