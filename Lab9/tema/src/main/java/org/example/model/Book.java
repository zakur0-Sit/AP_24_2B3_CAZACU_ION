package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="books")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title", nullable = false, length = 1000)
    private String title;
    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();
    @Column(name="language", nullable = false, length = 100)
    private String language;
    @Column(name="pages", nullable = false)
    private int pages;
    @ManyToOne
    @JoinColumn(name="publishing_house_id")
    private PublishingHouse publishingHouse;

    public Book() {

    }
}
