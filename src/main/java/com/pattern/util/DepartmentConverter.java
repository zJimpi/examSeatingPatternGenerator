package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.DepartmentDto;
import com.pattern.entity.Department;


@Component // Indicates that this class is a Spring component and can be managed by the Spring container.
public class DepartmentConverter {
	
	// Converts a Department entity to a DepartmentDto (Data Transfer Object).
	public DepartmentDto convertEntityToDepartmentDto(Department dept) {
		DepartmentDto deptDto = new DepartmentDto(); // Create a new DepartmentDto object.
		
		if (dept != null) { // Check if the input Department entity is not null.
			BeanUtils.copyProperties(dept, deptDto); // Copy properties from the entity to the DTO.
		}
		
		return deptDto; // Return the populated DepartmentDto.
	}
	
	// Converts a DepartmentDto (Data Transfer Object) to a Department entity.
	public Department convertDepartmentDtoToEntity(DepartmentDto deptDto) {
		Department dept = new Department(); // Create a new Department entity.
		
		if (deptDto != null) { // Check if the input DepartmentDto is not null.
			BeanUtils.copyProperties(deptDto, dept); // Copy properties from the DTO to the entity.
		}
		
		return dept; // Return the populated Department entity.
	}
}