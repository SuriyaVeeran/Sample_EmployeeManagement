package com.emp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.Employee_Entity;
import com.emp.service.Employee_Service;

@RestController
@RequestMapping("/employee")
public class Employee_Controller {

	private Employee_Service empservice;

	public Employee_Controller(Employee_Service empservice) {
		super();
		this.empservice = empservice;
	}

//	@PostMapping("/status")
//	public ResponseEntity<Employee_Entity> create_Data(@RequestBody Employee_Entity data) {
//
//		return new ResponseEntity<Employee_Entity>(empservice.createData(data), HttpStatus.CREATED);
//
//	}

	@GetMapping("/alldetails")
	private List<Employee_Entity> retrieve_All_Employee_Data() {

		return empservice.getAllEmployeeData();

	}

	@GetMapping("{id}")
	private Employee_Entity retrieve_EmployeeData_ById(@PathVariable("id") long particularid) {

		return empservice.retrieveDataById(particularid);

	}

	@PutMapping("{id}")
	private ResponseEntity<Employee_Entity> update_the_leavecount(@PathVariable("id") long id,

			@RequestBody Employee_Entity updatedata) {

		return new ResponseEntity<Employee_Entity>(empservice.updateleavecountbyid(id, updatedata), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	private ResponseEntity<String> delete_Employee(@PathVariable long id) {

		empservice.deleteEmployee(id);

		return new ResponseEntity<String>("deleted succesfully", HttpStatus.OK);

	}

	@PostMapping("/status")
	private List<Employee_Entity> addlistofemployees
	(@RequestBody List<Employee_Entity> entity) {

		return empservice.addMultipleEmployee(entity);

	}

	@GetMapping("/workstatus/{status}")
	private List<Employee_Entity> retrieveemployeebystatus(@PathVariable("status") String status) {

		return empservice.retrieveByStatus(status);

	}

	@GetMapping("/highersalary")
	private List<Employee_Entity> salarygreater() {

		return empservice.retrieveSalaryGreater();

	}

	@GetMapping("/orderbysalary/{name}")
	private Employee_Entity orderbysalary(@PathVariable("name") String name) {

		return empservice.retrieveNameOrderBySalary(name);

	}

	@GetMapping("/query")
	private List<Employee_Entity> getAllByQuery() {

		return empservice.retrieveAllEmployeebyQuery();
	}

	@GetMapping("/terminatedemp")
	private List<Employee_Entity> terminatedEmployees() {

		return empservice.retrieveTerminatedEmployees();

	}

}
