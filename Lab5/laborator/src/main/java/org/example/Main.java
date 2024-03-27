package org.example;

public class Main
{
    public static void main(String[] args)
    {
        MasterDirectory repository = new MasterDirectory("C:\\Users");
        repository.displayContent();
    }
}