package com.pattern.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pattern.entity.Department;
import com.pattern.entity.Student;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SubjectDto {

	private int subId;
	
	@NotNull(message="subject name cannot be blank")
	@Size(max=30, message="max 30 charecters allowed")
	private String subName;
	
	private LocalDate examDate;
	
	@ManyToOne
	private Department department;
	
	@ManyToMany
	private List<Student> students;
}
