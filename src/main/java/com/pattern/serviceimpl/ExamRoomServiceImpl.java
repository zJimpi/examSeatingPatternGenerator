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


    // Autowired to inject ExamRoomRepository bean
    @Autowired
    ExamRoomRepository exRoomRepository;

    // Autowired to inject ExamRoomConverter bean
    @Autowired
    ExamRoomConverter exRoomConverter;

    // Method to save an ExamRoom entity to the database and return a DTO
    @Override
    public ExamRoomDto saveExamRoom(ExamRoom exRoom) {
        // Save the ExamRoom entity using the repository
        exRoomRepository.save(exRoom);
        
        // Convert the saved entity to a DTO using the converter
        return exRoomConverter.convertEntityToExamRoomDto(exRoom);
    }

    // Method to retrieve an ExamRoom by its ID and return it as a DTO
    @Override
    public ExamRoomDto getExamRoomById(int id) {
        // Find the ExamRoom entity by its ID in the repository
        ExamRoom exRoom = exRoomRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ExamRoom", "id", id));
        
        // Convert the found entity to a DTO using the converter
        return exRoomConverter.convertEntityToExamRoomDto(exRoom);
    }

    // Method to update an ExamRoom by its ID and return it as a DTO
    @Override
    public ExamRoomDto updateExamRoomById(int id, ExamRoom exRoom) {
       
        // Currently, this method returns null
        return null;
    }

    // Method to delete an ExamRoom by its ID
    @Override
    public void deleteExamRoomById(int id) {
    }

}
