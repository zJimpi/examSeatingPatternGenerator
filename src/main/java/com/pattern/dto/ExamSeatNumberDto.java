package com.pattern.dto;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.pattern.entity.ExamRoom;
import com.pattern.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamSeatNumberDto {

	private int seatId;
	
	private int seatNo;
	
	@ManyToOne
	private ExamRoom room;
	
	@OneToOne
	private Student std;
}
