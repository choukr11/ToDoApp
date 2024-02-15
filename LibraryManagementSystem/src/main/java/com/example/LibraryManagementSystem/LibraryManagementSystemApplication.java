package com.example.LibraryManagementSystem;
import com.example.LibraryManagementSystem.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LibraryManagementSystemApplication {
	@Autowired
	public static void main(String[] args) { SpringApplication.run(LibraryManagementSystemApplication.class, args);	}
}