package com.avisys.cim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avisys.cim.Customer;
import com.avisys.cim.repository.CustomerRepository;


@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository custRepo;
	
	public List<Customer> getAll(){			
		return custRepo.findAll();
	}
	
	public Customer getBymobileNumber(String mobileNumber) {
		
		return custRepo.findByMobileNumber(mobileNumber);
	}

	public List<Customer> getByFirstName(String name) {
		
		return custRepo.findByFirstNameContainingIgnoreCase(name);
	}
	
	public List<Customer> getByLastName(String name) {
		
		return custRepo.findByLastNameContainingIgnoreCase(name);
	}

	
	

}
