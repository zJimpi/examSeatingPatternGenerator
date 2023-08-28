package com.pattern.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="subject_details")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Subject {
	
	@Id
	private int subId;
	
	@Column(length=30, nullable=false)
	private String subName;
	
	@ManyToOne
	Department department;
	
	@ManyToMany
	private List<Student> students;

}