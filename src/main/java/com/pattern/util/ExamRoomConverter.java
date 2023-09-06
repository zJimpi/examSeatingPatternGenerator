package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.ExamRoomDto;
import com.pattern.entity.ExamRoom;

@Component
public class ExamRoomConverter {

	public ExamRoomDto convertEntityToExamRoomDto(ExamRoom exRoom)
	{
		ExamRoomDto exRoomDto =new ExamRoomDto();
		
		if(exRoom != null)
		{
			BeanUtils.copyProperties(exRoom, exRoomDto);
		}
		
		return exRoomDto;
	}
	
	public ExamRoom convertExamRoomDtoToEntity(ExamRoomDto exRoomDto)
	{
		ExamRoom exRoom =new ExamRoom();
		if(exRoomDto != null)
		{
			BeanUtils.copyProperties(exRoomDto, exRoom);
		}
		return exRoom;
	}
}
