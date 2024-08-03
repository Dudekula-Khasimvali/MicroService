package com.spring.micro.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.micro.entity.Address;
import com.spring.micro.model.AddressDetails;
import com.spring.micro.repository.AddressRepository;

@Service
public class AddressService {

	Logger logger = LoggerFactory.getLogger(AddressService.class);
	@Autowired
	AddressRepository addressRepository;
	
	public  Address createAddress(AddressDetails addressDetails) {
		
		Address address = new Address();
		address.setStreet(addressDetails.getStreet());
		address.setCity(addressDetails.getCity());
		
		return addressRepository.save(address);
	}

	public List<Address> getallAddress() {
		return addressRepository.findAll();
	}

	public  Optional<Address> getAddress(long id) {
		
		logger.info("This is AddressService Exa"+id);
		
		return addressRepository.findById(id);
	}

}
