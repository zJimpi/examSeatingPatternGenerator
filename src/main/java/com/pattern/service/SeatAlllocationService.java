package com.pattern.service;

import java.util.ArrayList;

import com.pattern.dto.SeatAllocationDto;
import com.pattern.entity.SeatAllocation;



public interface SeatAlllocationService {
	
	//assigning seat number to students
	ArrayList<ArrayList<Integer>> savePatternGeneration(SeatAllocation seatAllo, int roomId);
	
	//create 
	SeatAllocationDto saveSeatAllocation(SeatAllocation seatAllo);
	
	//update
	SeatAllocationDto updateSeatAllocationById(int id, SeatAllocation seatAllo);
	
	//read
	SeatAllocationDto getSeatAllocationById(int id);
	
	//delete
	void deleteSeatAlllocationById(int id);
	
}
