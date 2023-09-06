package com.pattern.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // This class is an entity that maps to a database table.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generating unique IDs for each department.
	private int deptId;
	
	@Column(length = 10, nullable = false, unique = true)
	private String deptName; // The name of the department, limited to 10 characters, and must be unique.

	@Column(nullable = true)
	private int totalStudents; // Total number of students in the department.

	@OneToMany // Defines a one-to-many relationship with the Student entity.
	private List<Student> students; // A list of students associated with this department.

	@OneToMany // Define a one-to-many relationship with the Subject entity.
	private List<Subject> subjects; // A list of subjects offered by this department.
}