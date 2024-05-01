package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;

import java.sql.Connection;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    private static DataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        dataSource = new HikariDataSource(config);
    }

    static void createBooksTableIfNotExists() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS books_table (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "title VARCHAR(1000), " +
                    "author VARCHAR(1000), " +
                    "language VARCHAR(50), " +
                    "pages INT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DBConnection() {}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();

    }
}
