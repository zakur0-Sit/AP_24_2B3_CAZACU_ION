package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Authors
{
    private int id;
    private String name;

    public Authors(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
