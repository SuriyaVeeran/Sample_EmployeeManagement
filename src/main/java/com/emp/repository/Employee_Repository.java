package com.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.emp.entity.Employee_Entity;


@EnableJpaRepositories
public interface Employee_Repository extends JpaRepository<Employee_Entity, Long> {

	// custom method for retrieve employee by Status

	List<Employee_Entity> findByStatus(String status);

	// custom method for retrieve salary order by ascending

	List<Employee_Entity> findByOrderBySalary();

	Employee_Entity findTopByNameOrderBySalaryDesc(String name);

	// JPQL ----> java persistence query language

	@Query("select e from Employee_Entity e")
	List<Employee_Entity> findAllEmployeeQuery();

//	@Query("select db from Employee_Entity db "
//			+ "where db.status = 'Terminated' "
//			+ "order by db.days_on_leave")

	@Query("SELECT db FROM Employee_Entity db WHERE db.status = 'Terminated' " + "ORDER BY db.daysOnLeave")
	List<Employee_Entity> findTerminatedEmployees();

//	@Transactional
//	@Modifying
//	@Query("UPDATE Employee_Entity db SET db.daysOnLeave = 12, db.status = 'Employeed' WHERE db.id = 17")
//	int updateDaysOnLeaveForBruceWayne(Long id, Employee_Entity entity);

}
