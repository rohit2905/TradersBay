package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CapstoneprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneprojectApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			
			public void addCorsmappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200/#");
			}
		};
	}

}
