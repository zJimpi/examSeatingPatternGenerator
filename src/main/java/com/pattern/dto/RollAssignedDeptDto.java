package com.pattern.dto;

import javax.persistence.OneToOne;

import com.pattern.entity.Department;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RollAssignedDeptDto {

	private int id;
	
	@OneToOne
	private Department dept;
	
	private int uniroll;
}
