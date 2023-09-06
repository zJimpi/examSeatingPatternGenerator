package com.pattern.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.SubjectDto;
import com.pattern.entity.Subject;
import com.pattern.exception.ResourceNotFoundException;
import com.pattern.repository.SubjectRepository;
import com.pattern.service.SubjectService;
import com.pattern.util.SubjectConverter;

@Service
public class SubjectServiceimpl implements SubjectService{

	@Autowired
	SubjectRepository subRepository;
	
	@Autowired
	SubjectConverter subConverter;
	
	@Override
	public SubjectDto saveSubject(Subject sub) {
	    // Custom method for generating university roll number
	    
	    // Save the subject to the repository
	    subRepository.save(sub);
	    
	    // Convert the saved subject entity to a SubjectDto and return it
	    return subConverter.convertEntityToSubjectDto(sub);
	}

	@Override
	public SubjectDto getSubjectById(int id) {
	    // Retrieve the subject from the repository by its ID, or throw a ResourceNotFoundException if not found
	    Subject sub = subRepository.findById(id).orElseThrow(() ->
	        new ResourceNotFoundException("Subject", "id", id));
	    
	    // Convert the retrieved subject entity to a SubjectDto and return it
	    return subConverter.convertEntityToSubjectDto(sub);
	}

	@Override
	public SubjectDto updateSubjectById(int id, Subject newSub) {
	    // Retrieve the existing subject from the repository by its ID
	    Subject existingSub = subRepository.findById(id).get();
	    
	    // Update the subject's name with the new name provided
	    existingSub.setSubName(newSub.getSubName());
	    
	    // Save the updated subject entity to the repository
	    subRepository.save(existingSub);
	    
	    // Convert the updated subject entity to a SubjectDto and return it
	    return subConverter.convertEntityToSubjectDto(existingSub);
	}

	@Override
	public void deleteSubjectById(int id) {
	    // Check if the subject with the given ID exists, or throw a ResourceNotFoundException if not found
	    subRepository.findById(id).orElseThrow(() ->
	        new ResourceNotFoundException("Subject", "id", id));
	    
	    // Delete the subject from the repository by its ID
	    subRepository.deleteById(id);    
	}

	@Override
	public List<SubjectDto> getSubjectLists(int stdId) {
	    // Retrieve a list of subjects by department ID from the repository
	    List<Subject> subjects = subRepository.getSubjectByDeptId(stdId);
	    
	    // Initialize a list to store SubjectDto objects
	    List<SubjectDto> subDtos = new ArrayList<>();
	    
	    // Convert each subject entity to a SubjectDto and add it to the list
	    for (Subject s : subjects) {
	        subDtos.add(subConverter.convertEntityToSubjectDto(s));
	    }    
	    
	    // Return the list of SubjectDto objects
	    return subDtos;
	}

}