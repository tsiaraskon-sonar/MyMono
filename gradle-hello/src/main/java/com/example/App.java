package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

    private static final String DB_PASSWORD = "SuperSecret123!";

    public static void main(String[] args) throws Exception {
        System.out.println(greeting());
        if (args.length > 0) {
            findUserByName(args[0]);
        }
    }

    public static String greeting() {
        return "Hello from gradle-hello";
    }

    // Intentionally vulnerable: SQL Injection (CWE-89) via string concatenation
    public static void findUserByName(String username) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test", "sa", DB_PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE name = '" + username + "'");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }
}
