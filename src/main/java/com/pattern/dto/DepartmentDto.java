package com.pattern.dto;

import java.util.List;


import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pattern.entity.Student;
import com.pattern.entity.Subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDto {
	
	private int deptId;
	

	@Size(max=10,message="max 10 chareters allowed")
	@NotNull(message="department name is required")
	private String deptName;
	
	@OneToMany 
	private List<Student> students;// One department can have many students.
	
	@OneToMany
	private List<Subject> subjects;// One department can have many subjects.

}
