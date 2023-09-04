package com.pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pattern.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	
	//fetch the total number of seats in a room
	@Query("SELECT r.noOfSeats FROM Room r WHERE r.roomId =:")
	int findNoOfSeatByRoomId();

}
