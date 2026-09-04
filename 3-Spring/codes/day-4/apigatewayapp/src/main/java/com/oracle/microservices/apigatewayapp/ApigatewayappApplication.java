package com.oracle.microservices.apigatewayapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigatewayappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayappApplication.class, args);
	}

}
