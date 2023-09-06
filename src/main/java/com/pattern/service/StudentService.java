package com.pattern.service;

import java.util.List;

import com.pattern.dto.StudentDto;
import com.pattern.dto.SubjectDto;
import com.pattern.entity.Student;

public interface StudentService {
	
	//create 
	StudentDto saveStudent(Student std);
	
	//read
	StudentDto getStudentById(int id);
	
	//update
	StudentDto updateStudentById(int id,Student std);
	
	//delete
	void deleteStudentById(int id);
	

	StudentDto assignUniRollNo(int stdId);
	
	//method to fetch student details using name
		List<StudentDto> getStudentByName(String name);
		
		//method to fetch student details using email
		StudentDto getStudentByEmail(String email);
		
		//method to fetch student details from a department using deptId
		List<StudentDto> getStudentByDeptName(String deptName);
}