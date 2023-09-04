package com.pattern.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pattern.dto.RoomDto;
import com.pattern.entity.Room;
import com.pattern.service.RoomService;
import com.pattern.util.RoomConverter;

@RestController
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	RoomConverter roomConverter;
	
	@PostMapping("/saveRoom")
	public RoomDto saveRoomDetails(@Valid @RequestBody RoomDto rDto)
	{
		Room room = roomConverter.convertRoomDtoToEntity(rDto);
		
		return roomService.saveRoom(room);
	}
	
	@GetMapping("/getRoomByNo/{roomNo}")
	public RoomDto getRoomDetailsByNo(@PathVariable("roomNo") int roomNo)
	{
		return roomService.getRoomByNo(roomNo);
	}
	
	
	@PutMapping("/updateRoomByNo/{roomNo}")
	public RoomDto updateRoomByNo(@PathVariable("roomNo") int roomNo,@RequestBody RoomDto rDto)
	{
		Room room = roomConverter.convertRoomDtoToEntity(rDto);
		
		return roomService.updateRoomByNo(roomNo, room);
	}
	
	@DeleteMapping("/deleteRoomByNo/{roomNo}")
	public ResponseEntity<String> deleteRoomByNo(@PathVariable("roomNo") int roomNo)
	{
		roomService.deleteRoomByNo(roomNo);
		return new ResponseEntity<String>("Room with No.:"+roomNo+" deleted sucessfully!",HttpStatus.OK);
	}
}