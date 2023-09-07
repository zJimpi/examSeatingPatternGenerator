package com.pattern.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pattern.entity.Department;
import com.pattern.entity.Student;
import com.pattern.repository.DepartmentRepository;
import com.pattern.repository.StudentRepository;
import com.pattern.service.DepartmentService;
import com.pattern.service.StudentService;

@SpringBootTest
public class DepartmentServiceTest {
	
	@Autowired
	DepartmentService deptService;
	
	@MockBean
	DepartmentRepository deptRepository;
	
	@Autowired
	StudentService stdService;
	
	@MockBean
	StudentRepository stdRepository;
	
	@Test
	@DisplayName("Save department test")
	void testPositiveSaveDepartment()
	{
		// Creating a Department object for testing
		Department dept = Department.builder().deptId(1).deptName("BCA").totalStudents(30).build();
	    
        Optional<Department> opDept = Optional.of(dept);
		
		// Mocking the behavior of the DepartmentRepository to return the created Department
		Mockito.when(deptRepository.findById(dept.getDeptId())).thenReturn(opDept);
		
		// Fetching the department name and asserting it matches the expected value
		String deptName = deptService.getDepartmentById(dept.getDeptId()).getDeptName();
		assertTrue(deptName.equals("BCA"));
	}
	
	@Test
	@DisplayName("save department negative test")
	void testNegativeSaveDepartment()
	{
		// Creating a Department object for testing
		Department dept = Department.builder().deptId(1).deptName("BCA").totalStudents(30).build();
	    
        Optional<Department> opDept = Optional.of(dept);
		
		// Mocking the behavior of the DepartmentRepository to return the created Department
		Mockito.when(deptRepository.findById(dept.getDeptId())).thenReturn(opDept);
		
		// Fetching the department name and asserting it does not match the expected value
		String deptName = deptService.getDepartmentById(dept.getDeptId()).getDeptName();
		assertTrue(deptName.equals("BBA"));
	}
	
	@Test
	@DisplayName("Assign student to department test")
	void testAssignStdToDept()
	{
		// Creating a Department and Student object for testing
		Department dept = Department.builder().deptId(1).deptName("BCA").totalStudents(30).build();
		Student std = Student.builder().stdName("Sangita Das").stdPhNo("123456789").stdEmail("sangita@gmail.com").build();
		Optional<Department> opDept = Optional.of(dept);

		// Mocking the behavior of the DepartmentRepository to return the created Department
		Mockito.when(deptRepository.findById(dept.getDeptId())).thenReturn(opDept);
		// Mocking the behavior of the StudentRepository to return the created Student
		Mockito.when(stdRepository.findById(std.getClassRoll())).thenReturn(Optional.of(std));
		
		// Calling the method to assign a student to a department
		deptService.assignStudentToDept(std.getClassRoll(), dept.getDeptId());
		
		// Asserting that the department name of the assigned student matches the expected value
		assertEquals(dept.getDeptName(), stdService.getStudentById(std.getClassRoll()).getDepartment().getDeptName());
	}
}
