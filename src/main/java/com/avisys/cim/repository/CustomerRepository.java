package com.avisys.cim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avisys.cim.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	Customer findByMobileNumber(String mobileNumber);

	List<Customer> findByFirstNameContainingIgnoreCase(String name);
	
	List<Customer> findByLastNameContainingIgnoreCase(String name);
	
	
	
	
	
	
	
	
	
	
	
}
