package com.avisys.cim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.repository.CustomerRepository;
import com.avisys.cim.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService custService;
	
	
	@GetMapping("/all")
	public List<Customer> getAll() {
		
		return custService.getAll();
		
	}
	
	@GetMapping("/mobileNo/{mobileNumber}")
	public Customer getBymobileNumber(@PathVariable  String mobileNumber) {
		
		return custService.getBymobileNumber(mobileNumber);
		
	}
	
	@GetMapping("/firstname/{name}")
	public List<Customer> getByFirstName(@PathVariable  String name) {
		
		return custService.getByFirstName(name);
		
	}
	
	@GetMapping("/lastname/{name}")
	public List<Customer> getByLastName(@PathVariable  String name) {
		
		return custService.getByLastName(name);
		
	}
	
	
	
	

 	
	
	
	

}
