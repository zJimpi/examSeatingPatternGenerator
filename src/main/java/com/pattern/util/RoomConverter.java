package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.RoomDto;
import com.pattern.entity.Room;

@Component
public class RoomConverter {
	
	public RoomDto convertEntityToRoomDto(Room room)
	{
		RoomDto rDto =new RoomDto();
		
		if(room != null)
		{
			BeanUtils.copyProperties(room, rDto);
		}
		
		return rDto;
	}
	
	public Room convertRoomDtoToEntity(RoomDto rDto)
	{
		Room room =new Room();
		if(rDto != null)
		{
			BeanUtils.copyProperties(rDto, room);
		}
		return room;
	}
}