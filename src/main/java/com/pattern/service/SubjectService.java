package com.pattern.service;


import java.util.List;

import com.pattern.dto.SubjectDto;
import com.pattern.entity.Subject;

public interface SubjectService {
	
	//Create and save a new Subject.
	SubjectDto saveSubject(Subject subject);
		
	//Retrieve a Subject by its unique ID.
	SubjectDto getSubjectById(int id);
			
	//Update a Subject by its unique ID.
	SubjectDto updateSubjectById(int id,Subject subject);
			
	//Delete a Subject by its unique ID.
	void deleteSubjectById(int id);
	
	//Retrieve a list of Subjects associated with a student.
	List<SubjectDto> getSubjectLists(int stdId);
}