package com.boot.empManagement.dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.boot.empManagement.entityManager.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="Employee")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empId", resolver = EntityIdResolver.class, scope=EmployeeDao.class)
public class EmployeeDao {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_id_seq")
//	@SequenceGenerator(name = "emp_id_seq", sequenceName = "emp_id_seq")
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="EMP_ID")
	private long empId;
	@Column(name="EMP_NAME")
	private String empName;
	@Column(name="P_PH_NO",nullable=false)
	private String pPhNo;
	@Column(name="S_PH_NO")
	private String sPhNo;
	@Column(name="EMAIL_ID",unique=true,nullable=false)
	private String emailId;
	
	@OneToMany(mappedBy="employeeDao", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<AddressDao> addresses; 
	
	public EmployeeDao(){
		
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public Set<AddressDao> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressDao> addresses) {
		this.addresses = addresses;
	}

	public String getpPhNo() {
		return pPhNo;
	}

	public void setpPhNo(String pPhNo) {
		this.pPhNo = pPhNo;
	}

	public String getsPhNo() {
		return sPhNo;
	}

	public void setsPhNo(String sPhNo) {
		this.sPhNo = sPhNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
