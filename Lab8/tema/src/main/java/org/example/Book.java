package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private int id;
    private String title;
    private String author;
    private String language;
    private int pages;

    public Book(int id, String title, String author, String language, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.language = language;
        this.pages = pages;
    }
}
