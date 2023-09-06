package com.pattern.service;

import java.util.List;

import com.pattern.dto.DepartmentDto;
import com.pattern.dto.SubjectDto;
import com.pattern.entity.Department;



public interface DepartmentService {
	
	//Create and save a new Department.
	DepartmentDto saveDepartment(Department dept);
	
	//Retrieve a Department by its unique ID.
	DepartmentDto getDepartmentById(int id);
		
	//Update a Department by its unique ID.
	DepartmentDto updateDepartmentById(int id,Department std);
		
	// Delete a Department by its unique ID.
	void deleteDepartmentById(int id);
	
	//Assign a student to a department.
	void assignStudentToDept(int stdid, int deptId);
	
	//Assign subjects to a department.
	void assignSubjectsToDept(int subid, int deptId);
	
	//Retrieve a Department by its name.
	DepartmentDto getDepartmentByName(String name);
	
	//Generate an exam routine for a department by department ID.
	List<SubjectDto> generateExamRoutineByDeptId(int deptId);
	
	//Retrieve the exam routine for a department by department ID.
	List<SubjectDto> getExamRoutineByDeptId(int deptId);

	//Get the total number of departments in the system.
	long getTotalNoOfDepartment();
	
	
	
}
