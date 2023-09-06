package com.pattern.service;


import java.util.List;

import com.pattern.dto.SubjectDto;
import com.pattern.entity.Subject;

public interface SubjectService {
	
	//create
	SubjectDto saveSubject(Subject subject);
		
	//read
	SubjectDto getSubjectById(int id);
			
	//update
	SubjectDto updateSubjectById(int id,Subject subject);
			
	//delete
	void deleteSubjectById(int id);
	
	List<SubjectDto> getSubjectLists(int stdId);
}