//package com.pattern.servicetest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.time.LocalDate;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.pattern.repository.StudentRepository;
//import com.pattern.service.StudentService;
//
//
//@SpringBootTest
//class StudentServiceTest {
//
//	@Autowired
//	StudentService stdService;
//	
//	@MockBean
//	StudentRepository stdRepository;
//	
//	@Test
//	void testSaveStudent()
//	{
//		Student std = Student.builder().name("Sangita").email("rupaidas@gmail.com").dateOfBirth(LocalDate.of(2003, 9, 6)).dateOfJoining(LocalDate.of(2023, 9, 2)).contact("124608536").address(add).build();
//	    
//		Mockito.when(stdRepository.save(std)).thenReturn(std);
//		
//		assertEquals("Sangita", stdService.saveStudent(std).getName());
//	}
//}