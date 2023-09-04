package com.pattern.service;

import com.pattern.dto.StudentDto;
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

}
