package com.boot.empManagement.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.boot.empManagement.dao.EmployeeDao;
import com.boot.empManagement.repository.EmployeeRepository;
import com.boot.empManagement.vo.Message;
@Repository
public class EmployeeDaoImpl{
	
	private final EmployeeRepository employeeRepository;
	@Autowired
	private Message message;
	
	@Autowired
	public EmployeeDaoImpl(EmployeeRepository crd) {
		this.employeeRepository = crd;
	}
	
	@Bean
	public Message message(){
		return  new Message();
	}
	
	public Iterable<EmployeeDao> findAll(){
		return employeeRepository.findAll();
	}
	
	public EmployeeDao saveEmployee(EmployeeDao employeeDao) {
		//Bidirectional mapping to have foreignKey relation
		employeeDao.getAddresses().stream().forEach(address -> address.setEmployeeDao(employeeDao));
		
		return employeeRepository.save(employeeDao);
	}

	public EmployeeDao findByEmployee(long empId) {
		return employeeRepository.findOne(empId);
	}
	
	public Message deleteEmployee(long empId){
		try{
			employeeRepository.delete(empId);
			message.setStatusCode(0);
			message.setMessage("Employee with Employee Id -"+empId+" deleted successfully.");
		}catch(Exception e){
			message.setStatusCode(1);
			message.setMessage("Employee with Employee Id: "+empId+" does not exists.");
			e.getMessage();
		}
		return message;
	}

}
