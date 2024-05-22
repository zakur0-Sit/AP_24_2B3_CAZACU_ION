package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }

    public void addBook(Book book) {
        String query = "INSERT INTO books (title, author, language, pageNumber) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getLanguage());
            statement.setInt(4, book.getPageNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId) {
        String query = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks()
    {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String language = resultSet.getString("language");
                int pageNumber = resultSet.getInt("pageNumber");
                books.add(new Book(id, title, author, language, pageNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

}