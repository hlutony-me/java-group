package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
//@EnableAutoConfiguration
@EnableDiscoveryClient
public class SpringBootJpaDeptValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaDeptValidationApplication.class, args);
		System.out.println("Spring Boot JPA started");
	}

}
