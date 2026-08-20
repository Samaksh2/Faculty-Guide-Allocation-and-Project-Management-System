package com.college.guide;
import java.sql.*;
public final class Database {
  private static final String URL=System.getenv().getOrDefault("DB_URL","jdbc:postgresql://localhost:5432/faculty_guide_db");
  private static final String USER=System.getenv().getOrDefault("DB_USER","postgres");
  private static final String PASS=System.getenv().getOrDefault("DB_PASSWORD","");
  public static Connection get() throws SQLException { return DriverManager.getConnection(URL,USER,PASS); }
}
