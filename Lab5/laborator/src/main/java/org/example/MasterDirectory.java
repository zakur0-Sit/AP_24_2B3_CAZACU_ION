package org.example;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MasterDirectory
{
    private final String masterDirectory;

    public MasterDirectory(String masterDirectory) {
        this.masterDirectory = masterDirectory;
    }

    public void displayContent()
    {
        File directory = new File(masterDirectory);
        if(!directory.exists() || !directory.isDirectory())
        {
            System.out.println("Current master directory do not exists or is not a directory");
            return;
        }

        File[] personDirectory = directory.listFiles(File::isDirectory);
        if(personDirectory == null || personDirectory.length == 0)
        {
            System.out.println("No user directory in master directory");
            return;
        }

        System.out.println("Repository content : ");
        for(File files : personDirectory)
        {
            System.out.println("Person directory : " + files.getName());
            File[] documents = files.listFiles();
            if(documents != null)
            {
                List<File> fileList = Arrays.asList(documents);
                fileList.forEach(elem -> System.out.println("   " + elem.getName()));
            }
        }

    }
}
