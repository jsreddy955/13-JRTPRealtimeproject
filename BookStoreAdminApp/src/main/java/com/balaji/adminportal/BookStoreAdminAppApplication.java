package com.balaji.adminportal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.balaji.adminportal.dao.BookRepository;

@SpringBootApplication
public class BookStoreAdminAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookStoreAdminAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			System.out.println(repository.findByAuthor("Balaji"));
		};
	}

}

