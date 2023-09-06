package com.pattern.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subId;
	
	@Column(length=30, nullable=false)
	private String subName;
	
	@Column(nullable=true)
	private LocalDate examDate;
	
	@ManyToOne
	private Department department;
	
	@ManyToMany
	private List<Student> students;
	
	

}