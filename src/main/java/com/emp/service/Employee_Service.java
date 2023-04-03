package com.emp.service;

import java.util.List;

import com.emp.entity.Employee_Entity;

public interface Employee_Service {
	
	Employee_Entity createData(Employee_Entity data);
	
	List<Employee_Entity> getAllEmployeeData();
	
	Employee_Entity retrieveDataById(long id);

	Employee_Entity updateleavecountbyid(long id, Employee_Entity data);
	
	void deleteEmployee(long id);
	
	List<Employee_Entity> addMultipleEmployee(List<Employee_Entity> entity);
	
	List<Employee_Entity> retrieveByStatus(String status);
	
	List<Employee_Entity> retrieveSalaryGreater();
	
	Employee_Entity retrieveNameOrderBySalary(String name);
	
	List<Employee_Entity> retrieveAllEmployeebyQuery();
	
	List<Employee_Entity> retrieveTerminatedEmployees();
	
	//int updateBruceWayneStatus(Long id, Employee_Entity entity);
	
	
}
