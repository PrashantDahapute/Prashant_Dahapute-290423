package com.avisys.cim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		
		return custRepo.findByFirstNameContainingIgnoreCase(name); //this will check 
	}
	
	public List<Customer> getByLastName(String name) {
		
		return custRepo.findByLastNameContainingIgnoreCase(name);
	}

	
	//for sending the http response responseentity is uses to send http code and body containing message.
	public ResponseEntity<String> createCustomer(Customer customer) {
		Customer cust=custRepo.findByMobileNumber(customer.getMobileNumber());//check any customer is present		
		//if cust is null that means there is no customer with this mobile number so add the customer.
		if(cust!=null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to create customer");
		}else {
			custRepo.save(customer);
			return ResponseEntity.ok("Customer Added successfully");
		}
	}

	
	

}
