package org.example.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="authors")
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable = false, length = 1000)
    private String name;
    @Column(name="surname", nullable = false, length = 1000)
    private String surname;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author() {}
}
