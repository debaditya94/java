package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("io.javabrains")
@SpringBootApplication

public class CourseApiDataApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CourseApiDataApplication.class, args);
		
	}

}
