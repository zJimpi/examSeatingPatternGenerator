package com.pattern.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.pattern.dto.SubjectDto;
import com.pattern.entity.Subject;
import com.pattern.service.SubjectService;
import com.pattern.util.SubjectConverter;

@RestController
public class SubjectController {
	
	@Autowired
	SubjectService subService;
	
	@Autowired
	SubjectConverter subConverter;
	
	@PostMapping("/saveSubject")
	public SubjectDto saveSubjectDetails(@Valid @RequestBody SubjectDto subDto)
	{
		Subject sub = subConverter.convertSubjectDtoToEntity(subDto);
		
		return subService.saveSubject(sub);
	}
	
	@GetMapping("/getSubjecttById/{id}")
	public SubjectDto getSubjectDetailsById(@PathVariable("id") int id)
	{
		return subService.getSubjectById(id);
	}
	
	
	@PutMapping("/updateSubjectById/{subId}")
	public SubjectDto updateSubjectById(@PathVariable("subId") int id,@RequestBody SubjectDto subDto)
	{
		Subject sub = subConverter.convertSubjectDtoToEntity(subDto);
		
		return subService.updateSubjectById(id, sub);
	}
	
	@DeleteMapping("/deleteSubjectById/{id}")
	public ResponseEntity<String> deletedsubjectById(@PathVariable("id") int subId)
	{
		subService.deleteSubjectById(subId);
		return new ResponseEntity<String>("Subject with Id:"+subId+" deleted sucessfully!",HttpStatus.OK);
	}
}