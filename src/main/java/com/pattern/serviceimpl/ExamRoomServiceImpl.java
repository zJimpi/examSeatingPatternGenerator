package com.pattern.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.ExamRoomDto;
import com.pattern.entity.ExamRoom;
import com.pattern.exception.ResourceNotFoundException;
import com.pattern.repository.ExamRoomRepository;
import com.pattern.service.ExamRoomService;
import com.pattern.util.ExamRoomConverter;

@Service
public class ExamRoomServiceImpl implements ExamRoomService{

	@Autowired
	ExamRoomRepository exRoomRepository;
	
	@Autowired
	ExamRoomConverter exRoomConverter;
	
	
	@Override
	public ExamRoomDto saveExamRoom(ExamRoom exRoom) {
		exRoomRepository.save(exRoom);
		return exRoomConverter.convertEntityToExamRoomDto(exRoom);
	}

	@Override
	public ExamRoomDto getExamRoomById(int id) {
		ExamRoom exRoom =exRoomRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("ExamRoom", "id", id));
		return exRoomConverter.convertEntityToExamRoomDto(exRoom);
	}

	@Override
	public ExamRoomDto updateExamRoomById(int id, ExamRoom exRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteExamRoomById(int id) {
		// TODO Auto-generated method stub
		
	}

}
