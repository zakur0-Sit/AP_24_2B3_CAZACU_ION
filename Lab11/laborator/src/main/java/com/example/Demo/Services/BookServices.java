package com.example.Demo.Services;

import com.example.Demo.ConnectionPool;
import com.example.Demo.Model.Book;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServices
{
    private final ConnectionPool connectionPool;

    public BookServices()
    {
        this.connectionPool = new ConnectionPool();
    }

    public Book createBook(Book book)
    {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO books (title, language, pages) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getLanguage());
            stmt.setInt(3, book.getPages());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                book.setId(rs.getInt(1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return book;
    }

    public Book getBookById(Integer id)
    {
        Book book = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT id, title, language, pages FROM books WHERE id = ?"))
        {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                String title = rs.getString("title");
                String language = rs.getString("language");
                Integer pages = rs.getInt("pages");
                Integer publishingHouseId = rs.getInt("publishing_house_id");
                book = new Book(id, title, language, pages);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, title, language, pages FROM books")) {
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String title = rs.getString("title");
                String language = rs.getString("language");
                Integer pages = rs.getInt("pages");
                Integer publishingHouseId = rs.getInt("publishing_house_id");
                books.add(new Book(id, title, language, pages));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book updateBookTitle(Integer id, Book book)
    {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement("UPDATE books SET title = ? WHERE id = ?"))
        {
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, id);
            int rowsUpdated = stmt.executeUpdate();
            if(rowsUpdated > 0)
            {
                book.setId(id);
                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteBook(Integer id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM books WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
