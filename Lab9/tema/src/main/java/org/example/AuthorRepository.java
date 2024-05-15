package org.example;

import jakarta.persistence.EntityManager;
import org.example.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository extends AbstractRepository<Author, Long> {
    public AuthorRepository(EntityManager entityManager) {
        super(Author.class);
    }

}