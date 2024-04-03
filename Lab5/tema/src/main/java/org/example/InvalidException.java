package org.example;

public class InvalidException extends Exception
{
    public InvalidException(Exception ex)
    {
        super("Invalid file.", ex);
    }
}