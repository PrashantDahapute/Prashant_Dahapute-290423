package com.avisys.cim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.avisys.cim.Customer;
import com.avisys.cim.MobileNumber;
import com.avisys.cim.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService custService;

	@GetMapping("/all")
	public List<Customer> getAll() {

		return custService.getAll();// return the list of customer

	}

	@GetMapping("/getAllnumber/{id}")
	public List<MobileNumber> get(@PathVariable Long id) {
		return custService.getAllNumber(id);
	}

	@GetMapping("/mobileNo/{mobileNumber}")
	public Customer getBymobileNumber(@PathVariable String mobileNumber) {

		return custService.getBymobileNumber(mobileNumber);

	}

	@GetMapping("/firstname/{name}")
	public List<Customer> getByFirstName(@PathVariable String name) {

		return custService.getByFirstName(name);

	}

	@GetMapping("/lastname/{name}")
	public List<Customer> getByLastName(@PathVariable String name) {

		return custService.getByLastName(name);

	}

	@DeleteMapping("/delete/{mobileNo}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String mobileNo) {

		return custService.removeCustomer(mobileNo);
	}

	@PostMapping("/add/{mobNo}")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer, @PathVariable String mobNo) {
		return custService.createCustomer(customer, mobNo);
	}

	// adding multiple number to existing customer
	@PostMapping("/addMobile/{id}")
	public String addmobile(@PathVariable Long id, @RequestBody MobileNumber mob) {
		return custService.addNo(id, mob);
	}

	// adding multiple number to existing customer
	@PostMapping("/deleteMobile/{id}")
	public String deleteMobileNo(@PathVariable Long id, @RequestBody MobileNumber mob) {
		return custService.removeNo(id, mob);
	}

}
