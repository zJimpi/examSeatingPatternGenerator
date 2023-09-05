package com.pattern.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pattern.entity.SeatAllocation;


public interface SeatAllocationRepository extends JpaRepository<SeatAllocation, Integer> {
	
	ArrayList<ArrayList<Integer>> savePatternGeneration(int roomId);

	@Query("from SeatAllocation where room=(from SeatAllocation where seatAlloId:=s)")
	int getRoomDetailsBySeatAllocationId(@Param("s") int seatAlloId);

}
