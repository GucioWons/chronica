package com.chronica.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupApplication.class, args);
	}

}
