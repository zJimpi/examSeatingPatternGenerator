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
		//custom method for generating university roll number
		
		subRepository.save(sub);
		
		return subConverter.convertEntityToSubjectDto(sub);
	}

	@Override
	public SubjectDto getSubjectById(int id) {
		
		Subject sub = subRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Subject", "id", id));
		
		return subConverter.convertEntityToSubjectDto(sub);
	}

	@Override
	public SubjectDto updateSubjectById(int id , Subject newSub) {
		
		Subject existingSub = subRepository.findById(id).get();
		
		existingSub.setSubName(newSub.getSubName());
		
		
		subRepository.save(existingSub);
		
		return subConverter.convertEntityToSubjectDto(existingSub);
	}

	@Override
	public void deleteSubjectById(int id) {
		
		subRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Subject", "id", id));
		
		subRepository.deleteById(id);	
	}

	@Override
	public List<SubjectDto> getSubjectLists(int stdId) {
		
		List<Subject> subjects = subRepository.getSubjectByDeptId(stdId);
		List<SubjectDto> subDtos = new ArrayList<>();
		for(Subject s : subjects)
		{
			subDtos.add(subConverter.convertEntityToSubjectDto(s));
		}		
		return subDtos;
	}
}