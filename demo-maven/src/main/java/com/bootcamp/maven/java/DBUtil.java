package com.bootcamp.maven.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
  private static final String URL = "jdbc:mysql://localhost:3306/bootcamp_db";
  private static final String USER = "root";
  private static final String PASSWORD = "123456";
  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

  // 2. 靜態區塊：確保類別載入時驅動程式只被註冊一次
  static {
    try {
      Class.forName(DRIVER);
    } catch (ClassNotFoundException e) {
      System.err.println("找不到資料庫驅動程式！");
      e.printStackTrace();
    }
  }

  // 3. 獲取連線的方法
  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  // 4. (選配) 關閉資源的輔助方法，雖然現在多用 try-with-resources，但寫著也專業
  public static void close(AutoCloseable... resources) {
    for (AutoCloseable res : resources) {
      if (res != null) {
        try {
          res.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
