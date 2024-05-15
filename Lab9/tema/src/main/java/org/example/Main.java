package org.example;

import jakarta.persistence.Persistence;
import org.example.model.Author;
import org.example.model.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.model.PublishingHouse;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        Handler fileHandler = new FileHandler("log.txt");
        logger.addHandler(fileHandler);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("book_pu");


        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            BookRepository bookRepository = new BookRepository(entityManager);
            AuthorRepository authorRepository = new AuthorRepository(entityManager);
            PublishingHouseRepository publishingHouseRepository = new PublishingHouseRepository(entityManager);

            // Adăugare publisher
            PublishingHouse publishingHouse = new PublishingHouse();
            publishingHouse.setName("Publisher");
            publishingHouseRepository.create(publishingHouse);
            logger.log(Level.INFO, "Publisher added: " + publishingHouse.getName());



            // Adăugare autor
            Author author = new Author();
            author.setName("Ion");
            author.setSurname("Cazacu");
            authorRepository.create(author);
            logger.log(Level.INFO, "Author added: " + author.getName() + " " + author.getSurname());

            // Adăugare carte
            Book book = new Book();
            book.setTitle("Example");
            book.setLanguage("Romana");
            book.setPages(100);
            book.setPublishingHouse(publishingHouse);
            book.getAuthors().add(author);
            bookRepository.create(book);
            logger.log(Level.INFO, "Book added: " + book.getTitle());

            // Căutare carte după ID
            Book foundBook = bookRepository.findById(book.getId());
            System.out.println("Book found: " + foundBook.getTitle());
            logger.log(Level.INFO, "Book found: " + foundBook.getTitle());

            // Ștergere carte
            bookRepository.delete(book.getId());
            logger.log(Level.INFO, "Book deleted by id : " + book.getId());

            // Căutare autor după ID (care nu există, va arunca o excepție)
            Author nonExistentAuthor = authorRepository.findById(100L);
            if(nonExistentAuthor == null) {
                logger.log(Level.INFO, "Author not found");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "A apărut o eroare:", e);
        } finally {
            Singleton.closeEntityManagerFactory();
        }
    }
}



