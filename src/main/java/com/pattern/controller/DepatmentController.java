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

import com.pattern.dto.DepartmentDto;
import com.pattern.dto.StudentDto;
import com.pattern.dto.SubjectDto;
import com.pattern.entity.Department;
import com.pattern.service.DepartmentService;
import com.pattern.util.DepartmentConverter;

@RestController//allows the class to handle the request made by the client
public class DepatmentController {
	
	@Autowired//automatically injects dependency
	DepartmentService deptService;//injecting DepartmentService
	
	@Autowired//automatically injects dependency
	DepartmentConverter deptConverter;//injecting DepartmentConverter

	//method to save department details
	@PostMapping("/saveDepartment")//url to invoke in postman
	public DepartmentDto saveDepartmentDetails(@Valid @RequestBody DepartmentDto deptDto)
	{
		Department dept = deptConverter.convertDepartmentDtoToEntity(deptDto);//converting dto to entity
		
		return deptService.saveDepartment(dept);//returning the entity object after saving in the repository
	}
	
	//method to get department details using department id
	@GetMapping("/getDepartmentById/{id}")//url to invoke in postman
	public DepartmentDto getDepartmentDetailsById(@PathVariable("id") int id)
	{
		return deptService.getDepartmentById(id);//invoking method from service layer
	}
	
	//method to update department using id
	@PutMapping("/updateDepartmentById/{deptId}")//url to invoke in postman
	public DepartmentDto updateDepartmentById(@PathVariable("deptId") int id,@RequestBody DepartmentDto deptDto)
	{
		Department dept = deptConverter.convertDepartmentDtoToEntity(deptDto);//converting dto to entity
		
		return deptService.updateDepartmentById(id, dept);//returning the entity object after updating in the repository
	}
	
	//method to delete department using id
	@DeleteMapping("/deleteDepartmentById/{id}")//url to invoke in postman
	public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") int deptId)
	{
		deptService.deleteDepartmentById(deptId);//invoking the delete method from service layer
		return new ResponseEntity<String>("Department with Id:"+deptId+" deleted sucessfully!",HttpStatus.OK);//confirmation message
	}
	
	//method to assign student to department
	@PostMapping("/assignStd/{sId}/toDept/{dId}")//url to invoke in postman
	public ResponseEntity<String> asssignStdToDept(@PathVariable("sId") int stdId, @PathVariable("dId") int deptId )
	{
		deptService.assignStudentToDept(stdId, deptId);//invoking the method from service layer to assign
		return new ResponseEntity<String>("Student with id "+stdId+" assigned to deopartment id "+deptId, HttpStatus.OK);//confirmation message
	}
	
	//method to get department details using department name
	@GetMapping("/getDepartmentByName/{name}")//url to invoke in postman
	public DepartmentDto getDepartmentDetailsByName(@PathVariable("name") String name)
	{
		return deptService.getDepartmentByName(name);//invoking method from service layer
	}
	
	//method to assign student to department
	@PostMapping("/assignSub/{subId}/toDept/{dId}")//url to invoke in postman
	public ResponseEntity<String> asssignSubToDept(@PathVariable("subId") int subId, @PathVariable("dId") int deptId )
	{
		deptService.assignSubjectsToDept(subId, deptId);//invoking the method from service layer to assign
		return new ResponseEntity<String>("Student with id "+subId+" assigned to department id "+deptId, HttpStatus.OK);//confirmation message
	}
	
	@PostMapping("/generateExamRoutine/{dId}")
	public List<SubjectDto> generateExamRoutineByDeptId(@PathVariable("dId") int deptId)
	{
		return deptService.generateExamRoutineByDeptId(deptId);	
	}
	
	@GetMapping("/getExamRoutine/{dId}")
	public List<SubjectDto> getExamRoutineByDeptId(@PathVariable("dId") int deptId)
	{
		return deptService.getExamRoutineByDeptId(deptId);
	}
}