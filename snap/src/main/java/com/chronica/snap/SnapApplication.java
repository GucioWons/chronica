package com.chronica.snap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {
		"com.chronica.snap",
		"org.chronica.library.exception.handler",
		"org.chronica.library.security"
})
public class SnapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnapApplication.class, args);
	}

}
