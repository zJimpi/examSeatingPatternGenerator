package com.pattern.service;

import com.pattern.dto.ExamRoomDto;
import com.pattern.entity.ExamRoom;

public interface ExamRoomService {

	//Create and save a new ExamRoom. 
	ExamRoomDto saveExamRoom(ExamRoom exRoom);
		
	//Retrieve an ExamRoom by its unique ID.
	ExamRoomDto getExamRoomById(int id);
		
	//Update an ExamRoom by its unique ID.
	ExamRoomDto updateExamRoomById(int id,ExamRoom exRoom);
		
	//Delete an ExamRoom by its unique ID
	void deleteExamRoomById(int id);
}
