package com.pattern.service;

import java.util.List;

import com.pattern.dto.StudentDto;
import com.pattern.entity.Student;

public interface StudentService {

	// Create and save a new Student.
	StudentDto saveStudent(Student std);

	// Retrieve a Student by their unique ID.
	StudentDto getStudentById(int id);

	// Update a Student by their unique ID.
	StudentDto updateStudentById(int id, Student std);

	// Delete a Student by their unique ID.
	void deleteStudentById(int id);

	
	//Assign a university roll number to a Student.
	StudentDto assignUniRollNo(int stdId);

	// method to fetch student details using name
	List<StudentDto> getStudentByName(String name);

	// method to fetch student details using email
	StudentDto getStudentByEmail(String email);

	// method to fetch student details from a department using deptId
	List<StudentDto> getStudentByDeptName(String deptName);

	//Retrieve a Student by university roll number and department ID.
	Student getStudentBYUniRollAndDeptId(int deptId, int uniRoll);

	//Get the last roll number of a department by department ID.
	int getLastRollOfDeptById(int DeptId);

	// method to fetch stdent deatils from dept using deptId
	List<StudentDto> getStudentsByDeptId(int deptId);

}
