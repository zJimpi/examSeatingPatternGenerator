package com.pattern.service;

import com.pattern.dto.DepartmentDto;
import com.pattern.entity.Department;



public interface DepartmentService {
	
	//create
	DepartmentDto saveDepartment(Department dept);
	
	//read
	DepartmentDto getDepartmentById(int id);
		
	//update
	DepartmentDto updateDepartmentById(int id,Department std);
		
	//delete
	void deleteDepartmentById(int id);
	
	
	void assignStudentToDept(int stdid, int deptId);
	
	void assignSubjectsToDept(int subid, int deptId);
	
	
	long getTotalNoOfDepartment();
	
	
	

}
