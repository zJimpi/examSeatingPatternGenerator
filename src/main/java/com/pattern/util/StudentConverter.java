package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.StudentDto;
import com.pattern.entity.Student;

@Component // Indicates that this class is a Spring component and can be managed by the Spring container.
public class StudentConverter {
	
	// Converts a Student entity to a StudentDto (Data Transfer Object).
	public StudentDto convertEntityToStudentDto(Student std) {
		StudentDto sDto = new StudentDto(); // Create a new StudentDto object.
		
		if (std != null) { // Check if the input Student entity is not null.
			BeanUtils.copyProperties(std, sDto); // Copy properties from the entity to the DTO.
		}
		
		return sDto; // Return the populated StudentDto.
	}
	
	// Converts a StudentDto (Data Transfer Object) to a Student entity.
	public Student convertStudentDtoToEntity(StudentDto sDto) {
		Student std = new Student(); // Create a new Student entity.
		
		if (sDto != null) { // Check if the input StudentDto is not null.
			BeanUtils.copyProperties(sDto, std); // Copy properties from the DTO to the entity.
		}
		
		return std; // Return the populated Student entity.
	}
}