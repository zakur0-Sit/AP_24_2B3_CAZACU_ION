package com.example.Demo.Controllers;

import com.example.Demo.Model.Author;
import com.example.Demo.Services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors", produces = "application/json")
public class AuthorController
{
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService)
    {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors()
    {
        return authorService.getAuthors();
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author)
    {
        Author createdAuthor = authorService.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Integer id)
    {
        Author author = authorService.getAuthorById(id);
        if (author != null)
            return ResponseEntity.ok(author);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<Author> updateAuthorName(@PathVariable Integer id, @RequestBody Author author)
    {
        Author updatedAuthor = authorService.updateAuthorName(id, author);
        if (updatedAuthor != null)
            return ResponseEntity.ok(updatedAuthor);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{id}/surname")
    public ResponseEntity<Author> updateAuthorSurname(@PathVariable Integer id, @RequestBody Author author)
    {
        Author updatedAuthor = authorService.updateAuthorSurname(id, author);
        if (updatedAuthor != null)
            return ResponseEntity.ok(updatedAuthor);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Integer id)
    {
        boolean deleted = authorService.deleteAuthor(id);
        if (deleted)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
