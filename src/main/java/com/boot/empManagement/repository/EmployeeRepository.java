package com.boot.empManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.empManagement.dao.EmployeeDao;

public interface EmployeeRepository extends CrudRepository<EmployeeDao, Long> {
	@SuppressWarnings("unchecked")
	@Override
	EmployeeDao save(EmployeeDao entity);
	
	@Override
	EmployeeDao findOne(Long entity); 
	
}
