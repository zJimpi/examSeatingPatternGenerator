package com.pattern.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SeatAllocation {

	@Id
	private int seatAlloId;//custom method
	
	private int seatNo;
	
	@OneToOne
	private Student student;
	
	@OneToOne
	private Room room;

	private ArrayList<ArrayList<Integer>> roomPattern ;
		
	
}
