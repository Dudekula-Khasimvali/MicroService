package com.spring.micro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.stereotype.Service;

import com.spring.micro.AddressFeignClient;
import com.spring.micro.entity.AddressResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {
	
	Logger logger = LoggerFactory.getLogger(CommonService.class);
	
	
	long count = 1;
	
	@Autowired
	AddressFeignClient addressFeignClient;

	@CircuitBreaker(name = "addressService",
			fallbackMethod = "fallbackGetAddressById")
	public AddressResponse getAddressById (long addressId) {
		logger.info("count = " + count);
		count++;
		AddressResponse addressResponse = addressFeignClient.getAddress(addressId);
		
		return addressResponse;
	}
	
	public AddressResponse fallbackGetAddressById (long addressId, Throwable th) {
		logger.error("Error = " + th);
		return new  AddressResponse();
	}
}