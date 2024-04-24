package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDAO {
    private Connection connection;

    public AuthorDAO() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }

    public void addAuthor(String name) {
        String query = "INSERT INTO authors (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAuthor(int authorId) {
        String query = "DELETE FROM authors WHERE author_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, authorId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}