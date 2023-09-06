package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.ExamRoomDto;
import com.pattern.entity.ExamRoom;

@Component // Indicates that this class is a Spring component and can be managed by the Spring container.
public class ExamRoomConverter {

    // Converts an ExamRoom entity to an ExamRoomDto (Data Transfer Object).
    public ExamRoomDto convertEntityToExamRoomDto(ExamRoom exRoom) {
        ExamRoomDto exRoomDto = new ExamRoomDto(); // Create a new ExamRoomDto object.

        if (exRoom != null) { // Check if the input ExamRoom entity is not null.
            BeanUtils.copyProperties(exRoom, exRoomDto); // Copy properties from the entity to the DTO.
        }

        return exRoomDto; // Return the populated ExamRoomDto.
    }

    // Converts an ExamRoomDto (Data Transfer Object) to an ExamRoom entity.
    public ExamRoom convertExamRoomDtoToEntity(ExamRoomDto exRoomDto) {
        ExamRoom exRoom = new ExamRoom(); // Create a new ExamRoom entity.

        if (exRoomDto != null) { // Check if the input ExamRoomDto is not null.
            BeanUtils.copyProperties(exRoomDto, exRoom); // Copy properties from the DTO to the entity.
        }

        return exRoom; // Return the populated ExamRoom entity.
    }
}