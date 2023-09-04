package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.SubjectDto;
import com.pattern.entity.Subject;

@Component
public class SubjectConverter {
	
	public SubjectDto convertEntityToSubjectDto(Subject sub)
	{
		SubjectDto subDto =new SubjectDto();
		
		if(sub != null)
		{
			BeanUtils.copyProperties(sub, subDto);
		}
		
		return subDto;
	}
	
	public Subject convertSubjectDtoToEntity(SubjectDto subDto)
	{
		Subject sub =new Subject();
		if(subDto != null)
		{
			BeanUtils.copyProperties(subDto, sub);
		}
		return sub;
	}
}