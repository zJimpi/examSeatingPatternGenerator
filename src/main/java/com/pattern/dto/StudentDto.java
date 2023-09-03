package com.pattern.dto;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pattern.entity.Department;
import com.pattern.entity.Subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

	private int uniRoll;
	
	@NotNull(message="Student name is required")
	@Size(max=30,message="max 30 charecters allowed")
	private String stdName; 
	
	@NotNull(message="Student phone number is required")
	@Size(min =10,max=10,message="enter 10 digit phone number")
	private String stdPhNo;
	
	
	@NotNull(message="Student email is required")
	@Size(max=20,message="max 20 charecters allowed")
	private String stdEmail;
	
	@ManyToOne
	private Department department;
	
	@ManyToMany
	private List<Subject> subject;
}
