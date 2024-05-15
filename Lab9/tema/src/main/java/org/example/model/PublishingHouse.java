package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="publishing_houses")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class PublishingHouse
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable = false, length = 1000)
    private String name;
    @OneToMany(mappedBy = "publishingHouse")
    private List<Book> books;

    public PublishingHouse() {}

}
