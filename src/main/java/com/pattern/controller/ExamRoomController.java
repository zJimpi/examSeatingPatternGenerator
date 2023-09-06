package com.pattern.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pattern.dto.ExamRoomDto;
import com.pattern.entity.ExamRoom;
import com.pattern.service.ExamRoomService;
import com.pattern.util.ExamRoomConverter;

@RestController
public class ExamRoomController {

	@Autowired
	ExamRoomService exRoomService;  // Autowired service for managing exam room details.

	@Autowired
	ExamRoomConverter exRoomConverter;  // Autowired converter for converting exam room data.

	// Method to save exam room details.
	@PostMapping("/saveExamRoom")
	public ExamRoomDto saveExamRoomDetails(@Valid @RequestBody ExamRoomDto exRoomDto)
	{
		// Convert the DTO (Data Transfer Object) to an entity object.
		ExamRoom exRoom = exRoomConverter.convertExamRoomDtoToEntity(exRoomDto);

		// Save the exam room details and return the saved DTO.
		return exRoomService.saveExamRoom(exRoom);
	}

	// Method to retrieve exam room details by room ID.
	@GetMapping("/getExamRoomById/{id}")
	public ExamRoomDto getExamRoomDetailsById(@PathVariable("id") int id)
	{
		// Retrieve exam room details by ID and return the DTO.
		return exRoomService.getExamRoomById(id);
	}
}

