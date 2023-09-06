package com.pattern.dto;

import java.util.List;

import javax.persistence.OneToMany;

import com.pattern.entity.ExamSeatNumber;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamRoomDto {

	private int roomId;
	
	private int totalSeats;
	
	@OneToMany
	private List<ExamSeatNumber> seatnumbers;
}
