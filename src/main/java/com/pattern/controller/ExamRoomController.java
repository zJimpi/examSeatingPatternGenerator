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
	ExamRoomService exRoomService;
	
	@Autowired
	ExamRoomConverter exRoomConverter;
	
	@PostMapping("/saveExamRoom")
	public ExamRoomDto saveExamRoomDetails(@Valid @RequestBody ExamRoomDto exRoomDto)
	{
		ExamRoom exRoom = exRoomConverter.convertExamRoomDtoToEntity(exRoomDto);
		
		return exRoomService.saveExamRoom(exRoom);
	}
	
	@GetMapping("/getExamRoomById/{id}")
	public ExamRoomDto getExamRoomDetailsById(@PathVariable("id") int id)
	{
		return exRoomService.getExamRoomById(id);
	}
	
}
