package com.pattern.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pattern.dto.ExamSeatNumberDto;
import com.pattern.entity.ExamRoom;
import com.pattern.entity.ExamSeatNumber;
import com.pattern.service.ExamSeatNumberService;
import com.pattern.util.ExamSeatNumberConverter;

@RestController
public class ExamSeatNumberController {
	
	@Autowired
	ExamSeatNumberService seatService;  // Autowired service for managing exam seat numbers.
	
	@Autowired
	ExamSeatNumberConverter seatConverter;  // Autowired converter for converting seat data.
	
	// to assign exam seat numbers to students in a specific room.
	@PostMapping("/assignExamSeatNumberToStudentByRoom/{roomId}")
	public ResponseEntity<String> assignExamSeatNumberToStudent(@PathVariable("roomId") int roomId)
	{
		seatService.saveExamSeatNumber(roomId);  // Save assigned seat numbers for students in the specified room.
		
		// Return a success response with a message indicating the assignment.
		return new ResponseEntity<String>("Students are assigned to seats in room id:" + roomId, HttpStatus.OK);
	}
	
	//to retrieve exam seat information by seat ID.
	@GetMapping("/getExamSeatNumberById/{id}")
	public ExamSeatNumberDto getExamSeatNumberById(@PathVariable("id") int id)
	{
		return seatService.getExamSeatNumberById(id);  // Retrieve exam seat information by ID.
	}
}

