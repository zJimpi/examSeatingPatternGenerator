package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.SubjectDto;
import com.pattern.entity.Subject;

@Component // Indicates that this class is a Spring component and can be managed by the Spring container.
public class SubjectConverter {
	
	// Converts a Subject entity to a SubjectDto (Data Transfer Object).
	public SubjectDto convertEntityToSubjectDto(Subject sub) {
		SubjectDto subDto = new SubjectDto(); // Create a new SubjectDto object.
		
		if (sub != null) { // Check if the input Subject entity is not null.
			BeanUtils.copyProperties(sub, subDto); // Copy properties from the entity to the DTO.
		}
		
		return subDto; // Return the populated SubjectDto.
	}
	
	// Converts a SubjectDto (Data Transfer Object) to a Subject entity.
	public Subject convertSubjectDtoToEntity(SubjectDto subDto) {
		Subject sub = new Subject(); // Create a new Subject entity.
		
		if (subDto != null) { // Check if the input SubjectDto is not null.
			BeanUtils.copyProperties(subDto, sub); // Copy properties from the DTO to the entity.
		}
		
		return sub; // Return the populated Subject entity.
	}
}