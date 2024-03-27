package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
abstract public class Person
{
    private String destination;
    private String name;
    private int age;
}
