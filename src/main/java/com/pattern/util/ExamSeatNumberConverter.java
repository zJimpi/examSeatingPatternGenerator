package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.ExamSeatNumberDto;
import com.pattern.entity.ExamSeatNumber;

@Component
public class ExamSeatNumberConverter {

	public ExamSeatNumberDto convertEntityToExamSeatNumberDto(ExamSeatNumber seat)
	{
		ExamSeatNumberDto seatDto =new ExamSeatNumberDto();
		
		if(seat!= null)
		{
			BeanUtils.copyProperties(seat, seatDto);
		}
		
		return seatDto;
	}
	
	public ExamSeatNumber convertExamSeatNumberDtoToEntity(ExamSeatNumberDto seatDto)
	{
		ExamSeatNumber seat =new ExamSeatNumber();
		if(seatDto != null)
		{
			BeanUtils.copyProperties(seatDto, seat);
		}
		return seat;
	}
}
