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

import com.pattern.entity.Student;
import com.pattern.repository.StudentRepository;
import com.pattern.service.StudentService;

@SpringBootTest
class StudentServiceTest {

	@Autowired
	StudentService stdService;
	
	@MockBean
	StudentRepository stdRepository;
	
	@Test
	@DisplayName("Positive Test Case 1 - Save Student")
	void testSaveStudent()
	{
		// Creating a Student object for testing
		Student std = Student.builder().stdName("Sangita Das").stdPhNo("123456789").stdEmail("sangita@gmail.com").build();
	    
		// Mocking the behavior of the StudentRepository to return the created Student
		Mockito.when(stdRepository.save(std)).thenReturn(std);
		
		// Asserting that the saved student's name matches the expected value
		assertEquals("Sangita Das", stdService.saveStudent(std).getStdName());
	}
	
	@Test
	@DisplayName("Positive Test Case 2 - Get Student by ID")
	void testGetStudentById()
	{
		// Creating a Student object for testing
		Student std = Student.builder().stdName("Sangita Das").stdPhNo("123456789").stdEmail("sangita@gmail.com").build();
		
		Optional<Student> opStd = Optional.of(std);
		
		// Mocking the behavior of the StudentRepository to return the created Student when searching by ID
		Mockito.when(stdRepository.findById(std.getClassRoll())).thenReturn(opStd);
		
		// Fetching the Student by ID and asserting that the email matches the expected value
		String email = stdService.getStudentById(std.getClassRoll()).getStdEmail();
		assertTrue(email.equals("sangita@gmail.com"));
	}
	
	@Test
	@DisplayName("Negative Test Case - Get Student by ID (Invalid Assertion)")
	void testNegativeGetStudentById()
	{
		// Creating a Student object for testing
		Student std = Student.builder().stdName("Sangita Das").stdPhNo("123456789").stdEmail("sangita@gmail.com").build();
		
		Optional<Student> opStd = Optional.of(std);
		
		// Mocking the behavior of the StudentRepository to return the created Student when searching by ID
		Mockito.when(stdRepository.findById(std.getClassRoll())).thenReturn(opStd);
		
		// This test demonstrates a negative case with an invalid assertion (intentional failure)
		// Uncomment the line below to perform a valid assertion
		//assertTrue(stdService.getStudentById(std.getClassRoll()).getStdEmail().equals("rupai@gmail.com"));
	}
}
