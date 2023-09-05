package com.pattern.service;

import com.pattern.dto.LastAssignedRollToDeptDto;
import com.pattern.entity.LastAssignedRollToDept;

public interface LastAssignedRollToDeptService {
	
	LastAssignedRollToDeptDto saveDeptAndUniRoll(LastAssignedRollToDept ldeptUni);
	
	LastAssignedRollToDeptDto updateUnirollByDeptId(int deptId,int uniRoll);

}
