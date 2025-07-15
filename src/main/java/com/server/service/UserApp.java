package com.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class UserApp {

	private static final Logger logger = LoggerFactory.getLogger(UserApp.class);


	public static void main(String[] args) {
		SpringApplication.run(UserApp.class, args);
	}

}
