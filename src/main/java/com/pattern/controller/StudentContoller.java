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

import com.pattern.dto.StudentDto;
import com.pattern.entity.Student;
import com.pattern.service.StudentService;
import com.pattern.util.StudentConverter;

@RestController
public class StudentContoller {
	
	@Autowired
	StudentService stdService;
	
	@Autowired
	StudentConverter stdConverter;
	
	@PostMapping("/saveStudent")
	public StudentDto saveStudentDetails(@Valid @RequestBody StudentDto sDto)
	{
		Student std = stdConverter.convertStudentDtoToEntity(sDto);
		
		return stdService.saveStudent(std);
	}
	
	@GetMapping("/getStudentById/{id}")
	public StudentDto getStudentDetailsById(@PathVariable("id") int id)
	{
		return stdService.getStudentById(id);
	}
	
	
	@PutMapping("/updateStudentById/{stuId}")
	public StudentDto updateStudentById(@PathVariable("stuId") int id,@RequestBody StudentDto sDto)
	{
		Student std = stdConverter.convertStudentDtoToEntity(sDto);
		
		return stdService.updateStudentById(id, std);
	}
	
	@DeleteMapping("/deleteStudentById/{id}")
	public ResponseEntity<String> deletedstudentById(@PathVariable("id") int stdId)
	{
		stdService.deleteStudentById(stdId);
		return new ResponseEntity<String>("Student with Id:"+stdId+" deleted sucessfully!",HttpStatus.OK);
	}
}