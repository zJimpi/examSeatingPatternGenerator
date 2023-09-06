package com.pattern.service;

import com.pattern.dto.RollAssignedDeptDto;
import com.pattern.entity.RollAssignedDept;

public interface RollAssignedDeptService {

		//create 
		RollAssignedDeptDto saveRollAssignedDept(RollAssignedDept dRoll);
		
		//read
		RollAssignedDeptDto getRollAssignedDeptById(int id);
		
		//update
		RollAssignedDeptDto updateRollAssignedDeptById(int id,RollAssignedDept dRoll);
		
		//delete
		void deleteRollAssignedDeptById(int id);
}
