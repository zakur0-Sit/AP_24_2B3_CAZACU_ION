package com.example.Demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Author
{
    private Integer id;
    private String name;
    private String surname;
}
