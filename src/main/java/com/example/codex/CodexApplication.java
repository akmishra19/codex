package com.example.codex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CodexApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodexApplication.class, args);
		System.out.println("Hello I am codex");
	}

}
