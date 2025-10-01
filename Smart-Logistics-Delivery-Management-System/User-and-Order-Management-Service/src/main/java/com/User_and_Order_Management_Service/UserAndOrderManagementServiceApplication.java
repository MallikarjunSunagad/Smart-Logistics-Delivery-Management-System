package com.User_and_Order_Management_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UserAndOrderManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAndOrderManagementServiceApplication.class, args);
	}

}
