package com.pattern.dto;

import javax.persistence.OneToOne;

import com.pattern.entity.Room;
import com.pattern.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatAllocationDto {

	private int seatNo;
	
	@OneToOne
	private Student student;
	
	@OneToOne
	private Room room;
}
