package com.emp.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.entity.Employee_Entity;
import com.emp.exception.ResourceNotFoundException;
import com.emp.repository.Employee_Repository;
import com.emp.service.Employee_Service;

@Service
public class EmployeeServiceImplementation implements Employee_Service {

	private Employee_Repository emprepo;

	public EmployeeServiceImplementation(Employee_Repository emprepo) {
		super();
		this.emprepo = emprepo;
	}

	@Override
	public Employee_Entity createData(Employee_Entity data) {
		return emprepo.save(data);
	}

	@Override
	public List<Employee_Entity> getAllEmployeeData() {

		return emprepo.findAll();

	}

	@Override
	public Employee_Entity retrieveDataById(long id) {
		return emprepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "empfield", id));
	}

	@Override
	public Employee_Entity updateleavecountbyid(long id, Employee_Entity data) {
		Employee_Entity existing_entity = emprepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "empfield", id));

		existing_entity.setName(data.getName());

		existing_entity.setSalary(data.getSalary());

		existing_entity.setDateofJoining(data.getDateofJoining());

		existing_entity.setDaysOnLeave(data.getDaysOnLeave());

		existing_entity.setStatus(data.getStatus());

		emprepo.save(existing_entity);

		return existing_entity;

	}

	@Override
	public void deleteEmployee(long id) {

		emprepo.deleteById(id);

	}

	@Override
	public List<Employee_Entity> addMultipleEmployee(List<Employee_Entity> entity) {

		return emprepo.saveAll(entity);
	}

	@Override
	public List<Employee_Entity> retrieveByStatus(String status) {
		return emprepo.findByStatus(status);
	}

	@Override
	public List<Employee_Entity> retrieveSalaryGreater() {
		return emprepo.findByOrderBySalary();
	}

	@Override
	public Employee_Entity retrieveNameOrderBySalary(String name) {
		return emprepo.findTopByNameOrderBySalaryDesc(name);
	}

	@Override
	public List<Employee_Entity> retrieveAllEmployeebyQuery() {
		return emprepo.findAllEmployeeQuery();
	}

	@Override
	public List<Employee_Entity> retrieveTerminatedEmployees() {
		return emprepo.findTerminatedEmployees();
	}

//	@Override
//	public int updateBruceWayneStatus(Long id,Employee_Entity entity) {
//
//		
//		return emprepo.updateDaysOnLeaveForBruceWayne(id,entity);
//	}

}
