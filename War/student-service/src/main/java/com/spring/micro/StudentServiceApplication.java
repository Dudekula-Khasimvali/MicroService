package com.spring.micro;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class StudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	 
//	@Bean
//	public RestTemplate restTemplate()
//	{
//		return new RestTemplate();
//	}
	
	
//	@Value("${address.service.url}")
//	private String addressServiceUrl;
//	@Bean
//	public WebClient webClient()
//	{
//		WebClient webClient = WebClient.builder()
//										.baseUrl(addressServiceUrl)
//										.build();
//			
//		return webClient;
//	}
}