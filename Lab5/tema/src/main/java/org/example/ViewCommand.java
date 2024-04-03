package org.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command
{
    private final Document[] documents;

    public ViewCommand(Document[] doc)
    {
        this.documents = doc;
    }

    public Person execute()
    {
        for(Document d:documents)
        {
            String path = d.getLocation();
            try
            {
                Desktop.getDesktop().open(new File(path));
            } catch (IOException e)
            {
                System.out.println("Error opening document " + e.getMessage());
            }
        }
        return null;
    }
}
