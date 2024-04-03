package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws InvalidException, FileNotFoundException
    {
        Person person = new Person("My Person");

        Document doc1 = new Document("1", "article1.txt", "C:\\Users\\zakur0\\Desktop\\Папка с папками\\UAIC\\PA\\Lab5\\tema\\testare\\article1.txt");
        doc1.addTag("author", "Ion");
        doc1.addTag("year", "2024");
        doc1.addTag("category", "PA");

        Document doc2 = new Document("2", "book1.txt", "C:\\Users\\zakur0\\Desktop\\Папка с папками\\UAIC\\PA\\Lab5\\tema\\testare\\book1.txt");
        doc2.addTag("author", "Author");
        doc2.addTag("year", "2021");
        doc2.addTag("category", "Literature");

        Document doc3 = new Document("3", "book2.txt", "C:\\Users\\zakur0\\Desktop\\Папка с папками\\UAIC\\PA\\Lab5\\tema\\testare\\book2.txt");
        doc3.addTag("author", "Andrei");
        doc3.addTag("year", "2023");
        doc3.addTag("category", "OOP");

        Scanner scanner = new Scanner(System.in);

        String path = new File("person.json").getAbsolutePath();
        Command addCommand = new AddCommand(person, new Document[]{doc1, doc2, doc3});
        Command viewCommand = new ViewCommand(new Document[]{doc1, doc2, doc3});
        Command reportCommand = new ReportCommand(person, "C:\\Users\\zakur0\\Desktop\\Папка с папками\\UAIC\\PA\\Lab5\\tema\\testare\\person.html");
        Command exportCommand = new ExportCommand(person, path);

        addCommand.execute();
        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "view":
                    viewCommand.execute();
                    break;
                case "report":
                    reportCommand.execute();
                    break;
                case "export":
                    exportCommand.execute();
                    break;
                case "exit":
                    System.out.println("Exiting the shell.");
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}