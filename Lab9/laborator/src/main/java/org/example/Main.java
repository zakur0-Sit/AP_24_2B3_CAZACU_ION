package org.example;

import org.example.model.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Singleton.getEntityManagerFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        BookRepository bookRepository = new BookRepository(entityManager);

        Book book = new Book();
        book.setTitle("Java Programming");
        book.setAuthor("John Doe");
        book.setLanguage("English");
        book.setPages(1178);

        bookRepository.create(book);

        Book foundBook = bookRepository.findById(2L);
        System.out.println("Found book: " + foundBook);

        List<Book> booksByName = bookRepository.findByName("Java");
        System.out.println("Books with name pattern : " + booksByName);

        entityManager.close();
        Singleton.closeEntityManagerFactory();
    }
}
