package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.DepartmentDto;
import com.pattern.entity.Department;

@Component
public class DepartmentConverter {
	
	public DepartmentDto convertEntityToDepartmentDto(Department dept)
	{
		DepartmentDto deptDto = new DepartmentDto();
		
		if(dept != null)
		{
			BeanUtils.copyProperties(dept, deptDto);
		}
		return deptDto;
	}
	
	public Department convertDepartmentDtoToEntity(DepartmentDto deptDto)
	{
		Department dept = new Department();
		if(deptDto != null)
		{
			BeanUtils.copyProperties(deptDto, dept);
		}
		return dept;
	}

}
