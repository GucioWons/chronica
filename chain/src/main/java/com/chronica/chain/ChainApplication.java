package com.chronica.chain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {
        "com.chronica.chain",
        "org.chronica.library.exception.handler",
        "org.chronica.library.security"
})
public class ChainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChainApplication.class, args);
    }

}
