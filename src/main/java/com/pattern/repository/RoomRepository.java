package com.pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pattern.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	
	//fetch the total number of seats in a room
	@Query("from Room where noOfSeats=(from Room where roomNo=:r)")
	int findNoOfSeatByRoomId(@Param("r") int roomId);

}
