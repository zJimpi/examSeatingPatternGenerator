package com.pattern.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pattern.entity.ExamRoom;
import com.pattern.repository.ExamRoomRepository;
import com.pattern.service.ExamRoomService;

@SpringBootTest
public class ExamRoomServiceTest {
	
	@Autowired
	ExamRoomService examroomService;
	
	@MockBean
	ExamRoomRepository examroomRepository;
	
	@Test
	@DisplayName("Positive Test Case 1 - Save Exam Room")
	void testSaveExamRoom()
	{
		// Creating an ExamRoom object for testing
		ExamRoom er = ExamRoom.builder().roomId(1).totalSeats(20).build();
	    
		// Mocking the behavior of the ExamRoomRepository to return the created ExamRoom
		Mockito.when(examroomRepository.save(er)).thenReturn(er);
		
		// Asserting that the total seats of the saved ExamRoom match the expected value
		assertEquals(20, examroomService.saveExamRoom(er).getTotalSeats());
	}
	
	@Test
	@DisplayName("Positive Test Case 2 - Get Exam Room by ID")
	void testGetExamRoomById()
	{
		// Creating an ExamRoom object for testing
		ExamRoom er = ExamRoom.builder().roomId(1).totalSeats(20).build();
		
		Optional<ExamRoom> opEr = Optional.of(er);
		
		// Mocking the behavior of the ExamRoomRepository to return the created ExamRoom when searching by ID
		Mockito.when(examroomRepository.findById(er.getRoomId())).thenReturn(opEr);
		
		// Fetching the ExamRoom by ID and asserting that the room ID matches the expected value
		int id = examroomService.getExamRoomById(1).getRoomId();
		assertEquals(id, examroomService.saveExamRoom(er).getRoomId());
	}
	
	@Test
	@DisplayName("Negative Test Case - Get Exam Room by ID (Invalid Assertion)")
	void testNegativeGetExamRoomById()
	{
		// Creating an ExamRoom object for testing
		ExamRoom er = ExamRoom.builder().roomId(1).totalSeats(20).build();
		
		Optional<ExamRoom> opEr = Optional.of(er);
		
		// Mocking the behavior of the ExamRoomRepository to return the created ExamRoom when searching by ID
		Mockito.when(examroomRepository.findById(er.getRoomId())).thenReturn(opEr);
		
		assertEquals(3, examroomService.saveExamRoom(er).getRoomId());
	}
}
