package com.pattern.service;

import com.pattern.dto.RollAssignedDeptDto;
import com.pattern.entity.RollAssignedDept;

public interface RollAssignedDeptService {

	//Create and save a new RollAssignedDept entry. 
	RollAssignedDeptDto saveRollAssignedDept(RollAssignedDept dRoll);
		
	//Retrieve a RollAssignedDept entry by its unique ID.
	RollAssignedDeptDto getRollAssignedDeptById(int id);
		
	//Update a RollAssignedDept entry by its unique ID.
	RollAssignedDeptDto updateRollAssignedDeptById(int id,RollAssignedDept dRoll);
		
	//Delete a RollAssignedDept entry by its unique ID.
	void deleteRollAssignedDeptById(int id);
}
