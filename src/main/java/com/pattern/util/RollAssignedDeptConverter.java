package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.RollAssignedDeptDto;
import com.pattern.entity.RollAssignedDept;


@Component
public class RollAssignedDeptConverter {

	public RollAssignedDeptDto convertEntityToRollAssignedDeptDto(RollAssignedDept dRoll)
	{
		RollAssignedDeptDto dRollDto =new RollAssignedDeptDto();
		
		if(dRoll != null)
		{
			BeanUtils.copyProperties(dRoll, dRollDto);
		}
		
		return dRollDto;
	}
	
	public RollAssignedDept convertRollAssignedDeptDtoToEntity(RollAssignedDeptDto dRollDto)
	{
		RollAssignedDept dRoll =new RollAssignedDept();
		if(dRollDto != null)
		{
			BeanUtils.copyProperties(dRollDto, dRoll);
		}
		return dRoll;
	}
	
}
