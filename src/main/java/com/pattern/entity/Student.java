package com.pattern.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="student_details")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	
	@Id
	private int uniRoll;
	
	@Column(length = 30, nullable = false)
	private String stdName; 
	@Column(length = 10, nullable = false)
	private String stdPhNo;
	@Column(length = 20, nullable = false)
	private String stdEmail;
	
	@ManyToOne
	private Department department;
	
	private Subject subject;
}