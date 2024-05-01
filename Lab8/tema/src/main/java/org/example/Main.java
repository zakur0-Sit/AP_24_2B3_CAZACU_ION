package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBConnection.createBooksTableIfNotExists();
        String csvFilePath = "books.csv";
        try (Connection connection = DBConnection.getConnection()) {
            DataImporter.importDataFromCSV(csvFilePath, connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
