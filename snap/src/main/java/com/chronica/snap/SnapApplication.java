package com.chronica.snap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SnapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnapApplication.class, args);
	}

}
