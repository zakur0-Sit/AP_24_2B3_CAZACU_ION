package com.example.Demo;

import com.example.Demo.Model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
//
//	@Bean
//	CommandLineRunner run(RestTemplate restTemplate) {
//		return args -> {
//			String baseUrl = "http://localhost:8082/books";
//
//			// Create a new book
//			Book newBook = new Book(12, "The Great Gatsby", "English", 180);
//			Book createdBook = restTemplate.postForObject(baseUrl, newBook, Book.class);
//			System.out.println("Created Book: " + createdBook);
//
//			// Get all books
//			Book[] books = restTemplate.getForObject(baseUrl, Book[].class);
//			System.out.println("Books: ");
//			for (Book book : books) {
//				System.out.println(book);
//			}
//
//			// Get book by ID
//			Book bookById = restTemplate.getForObject(baseUrl + "/" + createdBook.getId(), Book.class);
//			System.out.println("Book by ID: " + bookById);
//
//			// Update book title
//			createdBook.setTitle("The Great Gatsby - Updated");
//			restTemplate.put(baseUrl + "/" + createdBook.getId() + "/title", createdBook);
//			Book updatedBook = restTemplate.getForObject(baseUrl + "/" + createdBook.getId(), Book.class);
//			System.out.println("Updated Book: " + updatedBook);
//
//			// Delete book
//			restTemplate.delete(baseUrl + "/" + createdBook.getId());
//			System.out.println("Deleted Book with ID: " + createdBook.getId());
//		};
//	}
}
