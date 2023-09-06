package com.pattern.service;

import com.pattern.dto.ExamSeatNumberDto;
import com.pattern.entity.ExamSeatNumber;

public interface ExamSeatNumberService {

	//create 
	void saveExamSeatNumber(int roomId);
	
	//read
	ExamSeatNumberDto getExamSeatNumberById(int id);
	
	//update
	ExamSeatNumberDto updateExamSeatNumberById(int id,ExamSeatNumber seat);
	
	//delete
	void deleteExamSeatNumberById(int id);
}
