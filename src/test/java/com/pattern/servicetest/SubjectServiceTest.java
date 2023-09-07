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

import com.pattern.entity.Subject;
import com.pattern.repository.SubjectRepository;
import com.pattern.service.SubjectService;

@SpringBootTest
public class SubjectServiceTest {
	
	@Autowired
	SubjectService subService;
	
	@MockBean
	SubjectRepository subRepository;
	
	@Test
	@DisplayName("Positive Test Case 1 - Save Subject")
	void testSaveSubject()
	{
		// Creating a Subject object for testing
		Subject sub = Subject.builder().subId(1).subName("BCA").build();
	    
		// Mocking the behavior of the SubjectRepository to return the created Subject
		Mockito.when(subRepository.save(sub)).thenReturn(sub);
		
		// Asserting that the saved subject's name matches the expected value
		assertEquals("BCA", subService.saveSubject(sub).getSubName());
	}
	
	@Test
	@DisplayName("Positive Test Case 2 - Get Subject by ID")
	void testGetSubjectById()
	{
		// Creating a Subject object for testing
		Subject sub = Subject.builder().subId(1).subName("JAVA").build();
		
		Optional<Subject> opSub = Optional.of(sub);
		
		// Mocking the behavior of the SubjectRepository to return the created Subject when searching by ID
		Mockito.when(subRepository.findById(sub.getSubId())).thenReturn(opSub);
		
		// Fetching the Subject by ID and asserting that the subject name matches the expected value
		String subName = subService.getSubjectById(sub.getSubId()).getSubName();
		assertTrue(subName.equals("JAVA"));
	}
	
	
	@Test
	@DisplayName("Negative Test Case - Get Subject by ID (Invalid Assertion)")
	void testNegativeGetSubjectById()
	{
		// Creating a Subject object for testing
		Subject sub = Subject.builder().subId(1).subName("JAVA").build();
		
		Optional<Subject> opSub = Optional.of(sub);
		
		// Mocking the behavior of the SubjectRepository to return the created Subject when searching by ID
		Mockito.when(subRepository.findById(sub.getSubId())).thenReturn(opSub);
		
		//instead of checking whole thing just check only one propertry
		String subName = subService.getSubjectById(sub.getSubId()).getSubName();
		assertTrue(subName.equals("OS"));
	}
}