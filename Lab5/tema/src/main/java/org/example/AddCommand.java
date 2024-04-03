package org.example;

import java.io.File;
import java.io.FileNotFoundException;

public class AddCommand implements Command
{
    private final Person person;
    private final Document[] documents;

    public AddCommand(Person person, Document[] documents)
    {
        this.person = person;
        this.documents = documents;
    }

    public Person execute() throws FileNotFoundException
    {
        for (Document document : documents)
        {
            File file = new File(document.getLocation());
            if (!file.exists())
            {
                throw new FileNotFoundException("File not found: " + document.getLocation());
            } else
            {
                person.add(document);
                System.out.println("Document " + document.getTitle() + " added to the person");
            }
        }
        return null;
    }

}
