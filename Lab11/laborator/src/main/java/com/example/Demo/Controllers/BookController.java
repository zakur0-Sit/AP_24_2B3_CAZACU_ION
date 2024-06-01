package com.example.Demo.Controllers;

import com.example.Demo.Model.Book;
import com.example.Demo.Services.BookServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books", produces = "application/json")
public class BookController
{
    private final BookServices bookServices;

    public BookController(BookServices bookServices)
    {
        this.bookServices = bookServices;
    }

    @GetMapping
    public List<Book> getAllBooks()
    {
        return bookServices.getBooks();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(Book book)
    {
        Book createdBook = bookServices.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id)
    {
        Book book = bookServices.getBookById(id);
        if (book != null)
            return ResponseEntity.ok(book);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{id}/title")
    public ResponseEntity<Book> updateBookTitle(@PathVariable Integer id, @RequestBody Book book)
    {
        Book updatedBook = bookServices.updateBookTitle(id, book);
        if (updatedBook != null)
            return ResponseEntity.ok(updatedBook);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer id)
    {
        boolean deleted = bookServices.deleteBook(id);
        if (deleted)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
