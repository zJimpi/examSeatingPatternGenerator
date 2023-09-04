package com.pattern.service;

import com.pattern.dto.RoomDto;
import com.pattern.entity.Room;

public interface RoomService {
	
	//create
	RoomDto saveRoom(Room room);
		
	//read
	RoomDto getRoomByNo(int roomNo);
			
	//update
	RoomDto updateRoomByNo(int roomNo,Room romm);
			
	//delete
	void deleteRoomByNo(int roomNo);
}
