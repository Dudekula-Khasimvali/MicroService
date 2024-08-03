package com.spring.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.micro.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
