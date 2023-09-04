package com.pattern.dto;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.pattern.entity.SeatAllocation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDto {

	private int roomNo;
	
	@NotNull(message ="no of seates cannot be null")
	private int noOfSeats;
	
	private int startRollNo;
	
	private int endRollNo;
	
	@OneToOne
	private SeatAllocation seatAllocation;
}
