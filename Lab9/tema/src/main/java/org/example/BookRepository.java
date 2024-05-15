package org.example;
import jakarta.persistence.EntityManager;
import org.example.model.Book;
import org.springframework.stereotype.Repository;


@Repository
public class BookRepository extends AbstractRepository<Book, Long>
{
    public BookRepository(EntityManager entityManager) {
        super(Book.class);
    }
}

