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
	ExamSeatNumberService seatService;
	
	@Autowired
	ExamSeatNumberConverter seatConverter;
	
	@PostMapping("/assignExamSeatNumberToStudentByRoom/{roomId}")
	public ResponseEntity<String> assignExamSeatNumberToStudent(@PathVariable("roomId") int roomId)
	{
		seatService.saveExamSeatNumber(roomId);
		
		return new ResponseEntity<String>("Student are assigned to seats in room id:"+roomId, HttpStatus.OK);
	}
	
	@GetMapping("/getExamSeatNumberById/{id}")
	public ExamSeatNumberDto getExamSeatNumberById(@PathVariable("id") int id)
	{
		return seatService.getExamSeatNumberById(id);
	}
	
	//get setdent details by roono

}
