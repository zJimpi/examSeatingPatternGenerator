package com.pattern.service;

import com.pattern.dto.ExamSeatNumberDto;
import com.pattern.entity.ExamSeatNumber;

public interface ExamSeatNumberService {

	//Create and save an ExamSeatNumber associated with a specific room. 
	void saveExamSeatNumber(int roomId);
	
	//Retrieve an ExamSeatNumber by its unique ID.
	ExamSeatNumberDto getExamSeatNumberById(int id);
	
	//Update an ExamSeatNumber by its unique ID.
	ExamSeatNumberDto updateExamSeatNumberById(int id,ExamSeatNumber seat);
	
	//Delete an ExamSeatNumber by its unique ID.
	void deleteExamSeatNumberById(int id);
}
