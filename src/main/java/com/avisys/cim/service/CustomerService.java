package com.avisys.cim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Customer> getAll(){			
		return custRepo.findAll();
	}
	
	public Customer getBymobileNumber(String mobileNumber) {
		
		List<MobileNumber> mobi=mobRepo.findAll();//getting all number present in the table
		
		for(MobileNumber mob:mobi) {
			if(mob.getMobileNumber().equals(mobileNumber)) {
				return mob.getCust();//return customer of the mobile number
			}
		}
		
		return null;
	}

	public List<Customer> getByFirstName(String name) {
		
		return custRepo.findByFirstNameContainingIgnoreCase(name); //this will check 
	}
	
	public List<Customer> getByLastName(String name) {
		
		return custRepo.findByLastNameContainingIgnoreCase(name);
	}

	public String addNo(Long id, MobileNumber mob) {
		try {
		Customer cust=custRepo.findById(id).get();
		cust.addnumber(mob);//this is helper method to add mobile object in list and set the 
							//customer to the mobile number
		mobRepo.save(mob);		
		return "successful";
		
		}catch(Exception e) {
			return "Invalid Id";
		}
	}

	
	//this api return all mobile number a customer is having
	public List<MobileNumber> getAllNumber(Long id) {
		
		try {
		Customer cust=custRepo.findById(id).get();
		return cust.getList();
		}catch(Exception e) {
			return null;
		}
	}
}
