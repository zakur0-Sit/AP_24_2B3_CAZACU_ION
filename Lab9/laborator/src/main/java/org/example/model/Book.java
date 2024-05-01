package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="books")
@Getter
@Setter
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="title", nullable = false, length = 1000)
    private String title;
    @Column(name="author", nullable = false, length = 1000)
    private String author;
    @Column(name="language", nullable = false, length = 100)
    private String language;
    @Column(name="pages", nullable = false)
    private int pages;

    public Book(Long id, String title, String author, String language, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.language = language;
        this.pages = pages;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", pages=" + pages +
                '}';
    }
}
