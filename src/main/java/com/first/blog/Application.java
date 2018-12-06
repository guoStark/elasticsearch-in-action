package com.first.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.first.blog","com.first.blog.repository.es"})
//@MapperScan("com.first.blog.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
