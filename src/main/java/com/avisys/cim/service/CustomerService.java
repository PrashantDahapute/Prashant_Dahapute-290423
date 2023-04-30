package com.avisys.cim.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.avisys.cim.Customer;
import com.avisys.cim.MobileNumber;
import com.avisys.cim.repository.CustomerRepository;
import com.avisys.cim.repository.MobileRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private MobileRepository mobRepo;

	public List<Customer> getAll() {
		return custRepo.findAll();
	}

	public Customer getBymobileNumber(String mobileNumber) {

		List<MobileNumber> mobi = mobRepo.findAll();// getting all number present in the table

		for (MobileNumber mob : mobi) {
			if (mob.getMobileNumber().equals(mobileNumber)) {
				return mob.getCust();// return customer of the mobile number
			}
		}

		return null;
	}

	public List<Customer> getByFirstName(String name) {

		return custRepo.findByFirstNameContainingIgnoreCase(name); // this will check
	}

	public List<Customer> getByLastName(String name) {

		return custRepo.findByLastNameContainingIgnoreCase(name);
	}

	

	// this api return all mobile number a customer is having
	public List<MobileNumber> getAllNumber(Long id) {

		try {
			Customer cust = custRepo.findById(id).get();
			return cust.getList();
		} catch (Exception e) {
			return null;
		}
	}

	// for sending the http response responseentity is uses to send http code and
	// body containing message.
	public ResponseEntity<String> createCustomer(Customer customer, String mobNo) {
		List<MobileNumber> mobi = mobRepo.findAll();

		for (MobileNumber mob : mobi) {

			if (mob.getMobileNumber().equals(mobNo)) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("already exists");
			}
		}
		custRepo.save(customer);
		return ResponseEntity.ok("Custmer addded Successfully");

	}

	public ResponseEntity<String> removeCustomer(String mobileNo) {

		List<MobileNumber> mobi = mobRepo.findAll();// getting all number present in the table

		for (MobileNumber mob : mobi) {
			if (mob.getMobileNumber().equals(mobileNo)) {
				custRepo.delete(mob.getCust());
				return ResponseEntity.ok("Custmer deleted Successfully");
			}
		}

	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("mobile number not exists");
	}
	
	
	public String addNo(Long id, MobileNumber mob) {
		try {
			Customer cust = custRepo.findById(id).get();
			cust.addnumber(mob);// this is helper method to add mobile object in list and set the
								// customer to the mobile number
			mobRepo.save(mob);
			return "mobile number added successful";

		} catch (Exception e) {
			return "Invalid Id";
		}
	}
	
	
	public String removeNo(Long id, MobileNumber mob) {
		try {
			Customer cust = custRepo.findById(id).get();
			List<MobileNumber> mobi = cust.getList();
			
			for(MobileNumber mb:mobi) {
				if(mb.getMobileNumber().equals(mob.getMobileNumber())) {
					cust.deleteNumber(mb);
					mobRepo.delete(mb);
					return "mobile number deleted successful";
				}
			}
			
			return "invalid Mobile Number";
			
		} catch (Exception e) {
			return "Invalid Id";
		}
	}
	

}
