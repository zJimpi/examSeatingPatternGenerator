package com.pattern.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamSeatNumber {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int seatId;
	
	@Column(nullable=true)
	private int seatNo;
	
	@ManyToOne
	private ExamRoom room;
	
	@OneToOne
	private Student std;
	
	
}
