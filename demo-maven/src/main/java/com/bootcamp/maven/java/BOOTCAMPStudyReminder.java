package com.bootcamp.maven.java;

public class BOOTCAMPStudyReminder {
  // ! JDBC WORK flow
  // ! 1.create a Connection
  // Connection conn = DriverManager.getConnection(...);
  // ! 2.create a Statement or PreparedStatement
  // Prepared Statement ps = conn.prepareStatement("SELECT
  // * FROM student");
  // ! 3. Execute SQL Query
  // ResultSet rs= ps.executeQuery();
  // ! 4. Process the Results
  // rs.getSting("name"), rs.next(), etc.
  // ! 5. Close the Connection
  // Always close resources(ResultSet, Statement, Connection) to avoid
  // memory leaks

  public static void close(AutoCloseable... resources) {
    for (AutoCloseable res : resources) {
      if (res != null) {
        try {
          res.close();
        } catch (Exception e) {
          // 僅記錄 Log，不中斷程式
          System.err.println("關閉資源失敗: " + e.getMessage());
        }
      }
    }
  }
}
