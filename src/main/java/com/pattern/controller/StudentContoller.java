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

import com.pattern.dto.StudentDto;
import com.pattern.entity.Student;
import com.pattern.service.StudentService;
import com.pattern.util.StudentConverter;

@RestController//allows the class to handle the request made by the client
public class StudentContoller {
	
	@Autowired//automatically injects dependency
	StudentService stdService;//injecting RoomService
	
	@Autowired//automatically injects dependency
	StudentConverter stdConverter;//injecting RoomConverter
	
	//method to save student details
	@PostMapping("/saveStudent")//url to invoke in postman
	public StudentDto saveStudentDetails(@Valid @RequestBody StudentDto sDto)
	{
		Student std = stdConverter.convertStudentDtoToEntity(sDto);//converting dto to entity
		
		return stdService.saveStudent(std);//returning the entity object after saving in the repository
	}
	
	//method to get student using id
	@GetMapping("/getStudentById/{id}")//url to invoke in postman
	public StudentDto getStudentDetailsById(@PathVariable("id") int id)
	{
		return stdService.getStudentById(id);//invoking method from service layer 
	}
	
	//method to update student details using id
	@PutMapping("/updateStudentById/{stuId}")//url to invoke in postman
	public StudentDto updateStudentById(@PathVariable("stuId") int id,@RequestBody StudentDto sDto)
	{
		Student std = stdConverter.convertStudentDtoToEntity(sDto);//converting dto to entity
		
		return stdService.updateStudentById(id, std);//returning the entity object after updating in the repository
	}
	
	//method to delete student using id
	@DeleteMapping("/deleteStudentById/{id}")//url to invoke in postman
	public ResponseEntity<String> deletedstudentById(@PathVariable("id") int stdId)
	{
		stdService.deleteStudentById(stdId);//invoking the delete method from service layer
		return new ResponseEntity<String>("Student with Id:"+stdId+" deleted sucessfully!",HttpStatus.OK);//confirmation message
	}
	
	//method to assign university roll number to students
	@GetMapping("/assignUniRoll/{id}")//url to invoke in postman
	public StudentDto assignUniRoll(@PathVariable("id") int id)
	{
		return stdService.assignUniRollNo(id);//invoking the assign method from service layer
	}
	
	@GetMapping("/getStudentByName/{name}")
	public List<StudentDto> findStudentByName(@PathVariable("name") String name)
    {
    	return stdService.getStudentByName(name);	
    }
	
	@GetMapping("/getStudentByEmail/{email}")
	public StudentDto findStudentByEmail(@PathVariable("email") String email)
    {
    	return stdService.getStudentByEmail(email);	
    }
	
	@GetMapping("/getStudentFromDept/{deptName}")
	public List<StudentDto> getStudentByDeptName(@PathVariable("deptName") String deptName)
	{
		return stdService.getStudentByDeptName(deptName);
	}
	
	@GetMapping("/getLastRollofDept/{deptId}")
	public int getLastRollOfDeptById(@PathVariable("deptId") int deptId) {
		
		
		return stdService.getLastRollOfDeptById(deptId);
	}
	
	@GetMapping("/getStudentsByDeptId/{dId}")
	public List<StudentDto> getStudentByDeptID(@PathVariable("dId") int deptId)
	{
		return stdService.getStudentsByDeptId(deptId);
	}
}