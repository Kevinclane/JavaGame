package com.JavaAPI;

import com.JavaAPI.Controllers.CharactersController;
import com.JavaAPI.Models.Character;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameApiApplication.class, args);

		System.out.println("Application Starting");
		System.out.println("Serving on Port: 8080");

	}
}
