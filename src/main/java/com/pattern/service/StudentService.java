package com.pattern.service;


import java.util.List;

import org.springframework.data.repository.query.Param;

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
	

	StudentDto assignUniRollNo(int stdId);

	Student getStudentBYUniRollAndDeptId(int deptId, int uniRoll);
	
	int getLastRollOfDeptById(int DeptId);
	
	
	//method to fetch stdent deatils from dept using deptId
	List<StudentDto> getStudentsByDeptId(int deptId);
	
}
