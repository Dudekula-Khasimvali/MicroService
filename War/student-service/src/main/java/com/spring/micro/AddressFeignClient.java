package com.spring.micro;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.micro.entity.AddressResponse;

@FeignClient(value = "address-service" , path = "/api/khasim" )
public interface AddressFeignClient {
	
		@GetMapping("/getByid/{id}")
		public AddressResponse getAddress(@PathVariable long id);

		

		
	
}