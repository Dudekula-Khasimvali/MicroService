package com.spring.micro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.micro.entity.Address;
import com.spring.micro.model.AddressDetails;
import com.spring.micro.service.AddressService;

@RestController
@RequestMapping("/api/khasim")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/save")
	public Address createAddress( @RequestBody AddressDetails addressDetails) {
		return addressService.createAddress(addressDetails);
	}
	
	@GetMapping("/getall")
	public List<Address> getallAddress() {
		return addressService.getallAddress();
	}
	
//	@GetMapping("/get/{id}")
//	public Optional<Address> getAddress(@PathVariable long id)
//	{
//		return addressService.getAddress(id);
//	}
	
	@GetMapping("/getByid/{id}")
	public Optional<Address> getAddress(@PathVariable long id)
	{
		return addressService.getAddress(id);
	}
}