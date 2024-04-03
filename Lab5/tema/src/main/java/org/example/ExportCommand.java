package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ExportCommand implements Command
{
    private final Person person;
    private final String fileName;

    public ExportCommand(Person person,String fileName)
    {
        this.person = person;
        this.fileName = fileName;
    }
    public Person execute(){
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            mapper.writeValue(new File(fileName), person);
        } catch (IOException e)
        {
            System.err.println("Error saving person to file: " + e.getMessage());
        }
        return null;
    }
}
