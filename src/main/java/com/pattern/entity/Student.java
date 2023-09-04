package com.pattern.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classRoll; //custom methods to insert the roll
	
	@Column(length=4, nullable = true)
	private int uniRoll;
	
	@Column(length = 30, nullable = false)
	private String stdName; 
	
	@Column(length = 10, nullable = false,unique=true)
	private String stdPhNo;
	
	@Column(length = 20, nullable = false, unique=true)
	private String stdEmail;
	
	@ManyToOne
	private Department department;
	
	@ManyToMany
	private List<Subject> subjects;
}