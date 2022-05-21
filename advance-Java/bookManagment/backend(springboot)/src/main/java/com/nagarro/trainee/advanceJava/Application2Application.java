package com.nagarro.trainee.advanceJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @ComponentScan(basePackages= {"com.nagarro.trainee.advanceJava"})
public class Application2Application {

	public static void main(String[] args) {
		SpringApplication.run(Application2Application.class, args);
		System.out.println("application 2 started");
	}

}
