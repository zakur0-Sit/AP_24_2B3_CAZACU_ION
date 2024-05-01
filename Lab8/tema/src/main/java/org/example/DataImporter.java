package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataImporter
{
    public static void importDataFromCSV(String csvFilePath, Connection connection)
    {
        String sql = "INSERT INTO books_table (title, author, language, pages) VALUES (?, ?, ?, ?)";
        try(BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            PreparedStatement statement = connection.prepareStatement(sql)) {

            String line = reader.readLine();
            while((line = reader.readLine()) != null)
            {
                String[] data = line.split(",");



                String title = data[1];
                String author = data[2];
                String language = data[6];
                int pages = Integer.parseInt(data[7]);
                statement.setString(1, title);
                statement.setString(2, author);
                statement.setString(3, language);
                statement.setInt(4, pages);
                statement.executeUpdate();
            }
            System.out.println("Data imported successfully");
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
