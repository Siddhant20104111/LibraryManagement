package com.harvard.libraryManagement;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		System.out.println("Working directory: " + System.getProperty("user.dir"));

		// Load .env file
		Dotenv dotenv = Dotenv.configure()
				.directory(".") // Looks for .env in project root
				.ignoreIfMissing() // Don't fail if .env is missing
				.load();

		System.out.println("DB_URL: " + dotenv.get("DB_URL"));
		System.out.println("DB_USERNAME: " + dotenv.get("DB_USERNAME"));
		System.out.println("DB_PASSWORD: " + dotenv.get("DB_PASSWORD"));

		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

}
