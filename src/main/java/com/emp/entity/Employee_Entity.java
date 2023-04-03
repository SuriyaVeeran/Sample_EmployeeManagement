package com.emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity

@Data
@NoArgsConstructor
@Table(name = "finaldb")
public class Employee_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;

	@Column
	private String dob;

	@Column
	private String status;

	@Column
	private String dateofJoining;

	@Column
	private int daysOnLeave;

	@Column
	private double salary;

}
