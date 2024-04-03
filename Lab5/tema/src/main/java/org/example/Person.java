package org.example;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable
{
    private String name;
    private final List<Document> docs = new ArrayList<>();

    public Person() {}

    public Person(String name)
    {
        this.name = name;
    }

    public void add(Document doc)
    {
        File file = new File(doc.getLocation());
        if (!file.exists())
        {
            System.out.println("File not found: " + doc.getLocation());
        } else
            docs.add(doc);
    }

    public List<Document> getDocs()
    {
        return docs;
    }

    public String getName()
    {
        return name;
    }

    public Document findById(String id)
    {
        return docs.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", docs=" + docs +
                '}';
    }

}