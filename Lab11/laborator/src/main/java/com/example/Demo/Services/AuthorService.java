package com.example.Demo.Services;

import com.example.Demo.ConnectionPool;
import com.example.Demo.Model.Author;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService
{
    private final ConnectionPool connectionPool;

    public AuthorService()
    {
        this.connectionPool = new ConnectionPool();
    }

    public Author createAuthor(Author author)
    {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO authors (name, surname) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, author.getName());
            stmt.setString(2, author.getSurname());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                author.setId(rs.getInt(1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return author;
    }

    public List<Author> getAuthors()
    {
        List<Author> authors = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, surname FROM authors"))
        {
            while (rs.next())
            {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                authors.add(new Author(id, name, surname));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return authors;
    }

    public Author getAuthorById(Integer id)
    {
        Author author = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT id, name, surname FROM authors WHERE id = ?"))
        {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                author = new Author(rs.getInt("id"), rs.getString("name"), rs.getString("surname"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return author;
    }

    public Author updateAuthorName(Integer id, Author author)
    {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement("UPDATE authors SET name = ? WHERE id = ?"))
        {
            stmt.setString(1, author.getName());
            stmt.setInt(2, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0)
            {
                author.setId(id);
                return author;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public Author updateAuthorSurname(Integer id, Author author)
    {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement("UPDATE authors SET surname = ? WHERE id = ?"))
        {
            stmt.setString(1, author.getSurname());
            stmt.setInt(2, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0)
            {
                author.setId(id);
                return author;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteAuthor(Integer id)
    {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM authors WHERE id = ?"))
        {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
