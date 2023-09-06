package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.ExamSeatNumberDto;
import com.pattern.entity.ExamSeatNumber;

@Component // Indicates that this class is a Spring component and can be managed by the Spring container.
public class ExamSeatNumberConverter {

    // Converts an ExamSeatNumber entity to an ExamSeatNumberDto (Data Transfer Object).
    public ExamSeatNumberDto convertEntityToExamSeatNumberDto(ExamSeatNumber seat) {
        ExamSeatNumberDto seatDto = new ExamSeatNumberDto(); // Create a new ExamSeatNumberDto object.

        if (seat != null) { // Check if the input ExamSeatNumber entity is not null.
            BeanUtils.copyProperties(seat, seatDto); // Copy properties from the entity to the DTO.
        }

        return seatDto; // Return the populated ExamSeatNumberDto.
    }

    // Converts an ExamSeatNumberDto (Data Transfer Object) to an ExamSeatNumber entity.
    public ExamSeatNumber convertExamSeatNumberDtoToEntity(ExamSeatNumberDto seatDto) {
        ExamSeatNumber seat = new ExamSeatNumber(); // Create a new ExamSeatNumber entity.

        if (seatDto != null) { // Check if the input ExamSeatNumberDto is not null.
            BeanUtils.copyProperties(seatDto, seat); // Copy properties from the DTO to the entity.
        }

        return seat; // Return the populated ExamSeatNumber entity.
    }
}