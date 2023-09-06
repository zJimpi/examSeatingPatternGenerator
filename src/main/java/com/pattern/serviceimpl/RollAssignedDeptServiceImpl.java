package com.pattern.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.RollAssignedDeptDto;
import com.pattern.entity.RollAssignedDept;
import com.pattern.exception.ResourceNotFoundException;
import com.pattern.repository.RollAssignedDeptRepository;
import com.pattern.service.RollAssignedDeptService;
import com.pattern.util.RollAssignedDeptConverter;


@Service
public class RollAssignedDeptServiceImpl implements RollAssignedDeptService{

	@Autowired
	RollAssignedDeptRepository dRollRepository;
	
	@Autowired
	RollAssignedDeptConverter dRollConverter;
	@Override
	public RollAssignedDeptDto saveRollAssignedDept(RollAssignedDept dRoll) {
		
		dRollRepository.save(dRoll);
		return dRollConverter.convertEntityToRollAssignedDeptDto(dRoll);
	}

	@Override
	public RollAssignedDeptDto getRollAssignedDeptById(int id) {
		RollAssignedDept dRoll = dRollRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("RollAssignedDept", "id", id));
		return dRollConverter.convertEntityToRollAssignedDeptDto(dRoll);
	}

	@Override
	public RollAssignedDeptDto updateRollAssignedDeptById(int id, RollAssignedDept dRoll) {
		
		RollAssignedDept existingDRoll =dRollRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("rollAssignedDept", "id", id));
		
		existingDRoll.setUniroll(dRoll.getUniroll());
		
		dRollRepository.save(existingDRoll);
		
		return dRollConverter.convertEntityToRollAssignedDeptDto(existingDRoll);
	}

	@Override
	public void deleteRollAssignedDeptById(int id) {
		// TODO Auto-generated method stub
		
	}

}
