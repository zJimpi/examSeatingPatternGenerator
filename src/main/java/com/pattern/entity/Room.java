package com.pattern.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="room_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Room {

	@Id
	private int roomNo;//given by authority
	
	@Column(nullable = false)
	private int noOfSeats;
	
	@Column(nullable = true)
	private int startRollNo;
	
	@Column(nullable = true)
	private int endRollNo;
	
	@OneToOne
	private SeatAllocation seatAllocation;
	
}
