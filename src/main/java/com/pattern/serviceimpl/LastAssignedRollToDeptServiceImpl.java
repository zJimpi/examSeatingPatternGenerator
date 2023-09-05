package com.pattern.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.pattern.dto.LastAssignedRollToDeptDto;
import com.pattern.entity.LastAssignedRollToDept;
import com.pattern.repository.LastAssignedRollToDeptRepository;
import com.pattern.service.LastAssignedRollToDeptService;

public class LastAssignedRollToDeptServiceImpl implements LastAssignedRollToDeptService {

	@Autowired
	LastAssignedRollToDeptRepository ldeptUniRepository;
	
	@Override
	public LastAssignedRollToDeptDto saveDeptAndUniRoll(LastAssignedRollToDept lDeptUni) {
		
		ldeptUniRepository.save(lDeptUni);
		
		return null;
	}

	@Override
	public LastAssignedRollToDeptDto updateUnirollByDeptId(int deptId,int uniRoll) {
		
		ldeptUniRepository.getBYDeptId(deptId);
		
		//update uniroll code 
		
		return null;
	}

	

	
}
