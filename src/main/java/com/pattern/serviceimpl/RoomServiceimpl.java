package com.pattern.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.RoomDto;
import com.pattern.entity.Room;
import com.pattern.exception.ResourceNotFoundException;
import com.pattern.repository.RoomRepository;
import com.pattern.service.RoomService;
import com.pattern.util.RoomConverter;

@Service
public class RoomServiceimpl implements RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	RoomConverter roomConverter;
	
	@Override
	public RoomDto saveRoom(Room room) {
		//custom method for generating university roll number
		
		roomRepository.save(room);
		
		return roomConverter.convertEntityToRoomDto(room);
	}

	@Override
	public RoomDto getRoomByNo(int roomNo) {
		
		Room room = roomRepository.findById(roomNo).orElseThrow(()->
		new ResourceNotFoundException("Room", "Room No.", roomNo));
		
		return roomConverter.convertEntityToRoomDto(room);
	}

	@Override
	public RoomDto updateRoomByNo(int roomNo , Room newRoom) {
		
		Room existingRoom = roomRepository.findById(roomNo).get();
		
		existingRoom.setRoomNo(newRoom.getRoomNo());
		existingRoom.setNoOfSeats(newRoom.getNoOfSeats());
		existingRoom.setStartRollNo(newRoom.getStartRollNo());
		existingRoom.setEndRollNo(newRoom.getEndRollNo());
		
		roomRepository.save(existingRoom);
		
		return roomConverter.convertEntityToRoomDto(existingRoom);
	}

	@Override
	public void deleteRoomByNo(int roomNo) {
		
		roomRepository.findById(roomNo).orElseThrow(()->
		new ResourceNotFoundException("Room", "Room No.", roomNo));
		
		roomRepository.deleteById(roomNo);	
	}
}