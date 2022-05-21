package com.nagarro.trainee.advanceJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.nagarro.trainee.advanceJava"})

public class Application {

	public static void main(String[] args) {
//		SpringApplication application = new SpringApplicationBuilder(MainApplication.class);
		SpringApplication.run(Application.class, args);
		System.out.println("project1 started");
	}

}
