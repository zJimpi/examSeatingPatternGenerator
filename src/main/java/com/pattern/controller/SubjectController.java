package com.pattern.controller;

import java.util.List;

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

@RestController//allows the class to handle the request made by the client
public class SubjectController {
	
	@Autowired//automatically injects dependency
	SubjectService subService;//injecting SubjectService
	
	@Autowired//automatically injects dependency
	SubjectConverter subConverter;//injecting SubjectConverter
	
	//method to save subject details
	@PostMapping("/saveSubject")//url to invoke in postman
	public SubjectDto saveSubjectDetails(@Valid @RequestBody SubjectDto subDto)
	{
		Subject sub = subConverter.convertSubjectDtoToEntity(subDto);//converting dto to entity
		
		return subService.saveSubject(sub);//returning the entity object after saving in the repository
	}
	
	//method to get subject details using subject id
	@GetMapping("/getSubjecttById/{id}")//url to invoke in postman
	public SubjectDto getSubjectDetailsById(@PathVariable("id") int id)
	{
		return subService.getSubjectById(id);//invoking method from service layer 
	}
	
	//method to update subject details using id
	@PutMapping("/updateSubjectById/{subId}")//url to invoke in postman
	public SubjectDto updateSubjectById(@PathVariable("subId") int id,@RequestBody SubjectDto subDto)
	{
		Subject sub = subConverter.convertSubjectDtoToEntity(subDto);//converting dto to entity
		
		return subService.updateSubjectById(id, sub);//returning the entity object after updating in the repository
	}
	
	//method to delete subject using id
	@DeleteMapping("/deleteSubjectById/{id}")//url to invoke in postman
	public ResponseEntity<String> deletedsubjectById(@PathVariable("id") int subId)
	{
		subService.deleteSubjectById(subId);//invoking the delete method from service layer
		return new ResponseEntity<String>("Subject with Id:"+subId+" deleted sucessfully!",HttpStatus.OK);//confirmation message
	}
	
	@GetMapping("/getSubjectListByDeptId/{deptId}")
	public List<SubjectDto> getSubjectList(@PathVariable("deptId") int id)
	{
		return subService.getSubjectLists(id);
	}
}