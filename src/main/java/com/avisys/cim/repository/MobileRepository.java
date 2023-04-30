package com.avisys.cim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avisys.cim.Customer;
import com.avisys.cim.MobileNumber;

public interface MobileRepository extends JpaRepository<MobileNumber, Long> {
	List<MobileNumber> findByCust(Customer cust);

}
