package org.example;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        DBConnection.getConnection();
        AuthorDAO authorDAO = new AuthorDAO();
        authorDAO.addAuthor("John Doe");
        Book book = new Book(1, "Java Programming2", "John Doe12132", "English", 500);
        BookDAO bookDAO = new BookDAO();
        bookDAO.addBook(book);
        bookDAO.deleteBook(5);
    }
}
