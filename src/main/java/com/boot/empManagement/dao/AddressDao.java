package com.boot.empManagement.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.boot.empManagement.entityManager.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="ADDRESS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "addId", resolver = EntityIdResolver.class, scope=AddressDao.class)
public class AddressDao {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "add_id_seq")
//	@SequenceGenerator(name = "add_id_seq", sequenceName = "add_id_seq")
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ADD_ID")
	private long addId;
	
	@Column(name = "ADDRESS_LINE_1")
	private String addressLine1;
	@Column(name = "ADDRESS_LINE_2")
	private String addressLine2;
	@Column(name="STREET")
	private String street;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="PRESENT_ADD")
	private boolean presentAdd;
	
	@ManyToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="EMP_ID")
	@JsonIgnore
	private EmployeeDao employeeDao;
	
	public AddressDao(){
		
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isPresentAdd() {
		return presentAdd;
	}
	public void setPresentAdd(boolean presentAdd) {
		this.presentAdd = presentAdd;
	}
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public long getAddId() {
		return addId;
	}

	public void setAddId(long addId) {
		this.addId = addId;
	}
}
