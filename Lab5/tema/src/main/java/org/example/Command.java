package org.example;

import java.io.FileNotFoundException;

public interface Command
{
    Person execute() throws InvalidException, FileNotFoundException;
}
