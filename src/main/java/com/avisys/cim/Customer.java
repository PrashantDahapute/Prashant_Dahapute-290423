package com.avisys.cim;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
//	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
//	 @SequenceGenerator(name = "CUSTOMER_SEQ", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	
	
	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@OneToMany(mappedBy = "cust",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<MobileNumber> list=new ArrayList<>();
	
	public void setList(List<MobileNumber> list) {
		this.list = list;
	}

	public void addnumber(MobileNumber num) {
		list.add(num);
		num.setCust(this);
	}
	
	public void deleteNumber(MobileNumber num) {
		list.remove(num);
		num.setCust(null);
	}
	

	public List<MobileNumber> getList() {
		return list;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

}
