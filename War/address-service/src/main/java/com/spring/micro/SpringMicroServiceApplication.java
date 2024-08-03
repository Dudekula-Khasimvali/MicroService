package com.spring.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMicroServiceApplication.class, args);
    }

}
