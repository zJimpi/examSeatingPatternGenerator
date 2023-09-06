package com.pattern.service;

import com.pattern.dto.ExamRoomDto;
import com.pattern.entity.ExamRoom;

public interface ExamRoomService {

	//create 
	ExamRoomDto saveExamRoom(ExamRoom exRoom);
		
		//read
	ExamRoomDto getExamRoomById(int id);
		
		//update
	ExamRoomDto updateExamRoomById(int id,ExamRoom exRoom);
		
		//delete
	void deleteExamRoomById(int id);
}
