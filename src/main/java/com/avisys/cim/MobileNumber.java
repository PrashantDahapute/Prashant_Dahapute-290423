package com.avisys.cim;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "MobileNumber")
public class MobileNumber  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name = "MObileNumber_SEQ", sequenceName = "MObileNumber_SEQ", allocationSize = 5 )
	private Long id;
	
	
	@Column(name = "MOBILE_NUMBER", nullable = false)
	private String mobileNumber;
	
	@JoinColumn(name="custid")
	@ManyToOne (fetch = FetchType.EAGER)
	@JsonBackReference
	private Customer cust;
	
	
	

	public MobileNumber() {
		super();
	}

	public MobileNumber(String mobileNumber) {
		super();
		this.mobileNumber = mobileNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
	
	
}
