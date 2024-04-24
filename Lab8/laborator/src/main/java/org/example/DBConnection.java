package org.example;

import java.sql.*;

import java.sql.Connection;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static Connection connection;

    private DBConnection() {}

    public static Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Connection to Store DB successful!");
                Statement statement = connection.createStatement();
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS books (id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(30), author VARCHAR(20), language VARCHAR(20), pageNumber INT)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
