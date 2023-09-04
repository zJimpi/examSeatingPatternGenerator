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

import com.pattern.dto.DepartmentDto;
import com.pattern.entity.Department;
import com.pattern.service.DepartmentService;
import com.pattern.util.DepartmentConverter;

@RestController
public class DepatmentController {
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	DepartmentConverter deptConverter;

	@PostMapping("/saveDepartment")
	public DepartmentDto saveDepartmentDetails(@Valid @RequestBody DepartmentDto deptDto)
	{
		Department dept = deptConverter.convertDepartmentDtoToEntity(deptDto);
		
		return deptService.saveDepartment(dept);
	}
	
	@GetMapping("/getDepartmentById/{id}")
	public DepartmentDto getDepartmentDetailsById(@PathVariable("id") int id)
	{
		return deptService.getDepartmentById(id);
	}
	
	
	@PutMapping("/updateDepartmentById/{deptId}")
	public DepartmentDto updateDepartmentById(@PathVariable("deptId") int id,@RequestBody DepartmentDto deptDto)
	{
		Department dept = deptConverter.convertDepartmentDtoToEntity(deptDto);
		
		return deptService.updateDepartmentById(id, dept);
	}
	
	@DeleteMapping("/deleteDepartmentById/{id}")
	public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") int deptId)
	{
		deptService.deleteDepartmentById(deptId);
		return new ResponseEntity<String>("Department with Id:"+deptId+" deleted sucessfully!",HttpStatus.OK);
	}
}