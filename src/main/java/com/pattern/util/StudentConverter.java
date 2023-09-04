package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.StudentDto;
import com.pattern.entity.Student;

@Component
public class StudentConverter {
	
	public StudentDto convertEntityToStudentDto(Student std)
	{
		StudentDto sDto =new StudentDto();
		
		if(std != null)
		{
			BeanUtils.copyProperties(std, sDto);
		}
		
		return sDto;
	}
	
	public Student convertStudentDtoToEntity(StudentDto sDto)
	{
		Student std =new Student();
		if(sDto != null)
		{
			BeanUtils.copyProperties(sDto, std);
		}
		return std;
	}
}