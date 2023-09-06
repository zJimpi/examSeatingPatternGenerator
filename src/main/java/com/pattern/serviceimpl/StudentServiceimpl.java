package com.pattern.serviceimpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.StudentDto;
import com.pattern.dto.SubjectDto;
import com.pattern.entity.Student;
import com.pattern.exception.ResourceNotFoundException;
import com.pattern.repository.StudentRepository;
import com.pattern.service.StudentService;
import com.pattern.util.StudentConverter;

@Service
public class StudentServiceimpl implements StudentService{

	@Autowired
	StudentRepository stdRepository;
	
	@Autowired
	StudentConverter stdConverter;
	
	@Override
	public StudentDto saveStudent(Student std) {
		//custom method for genrating university roll number
		
		
		stdRepository.save(std);
		
		return stdConverter.convertEntityToStudentDto(std);
	}

	@Override
	public StudentDto getStudentById(int id) {
		
		Student std = stdRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "id", id));
		
		return stdConverter.convertEntityToStudentDto(std);
	}

	@Override
	public StudentDto updateStudentById(int id , Student newStd) {
		
		Student existingStd = stdRepository.findById(id).get();
		
		existingStd.setStdName(newStd.getStdName());
		existingStd.setStdEmail(newStd.getStdEmail());
		existingStd.setStdPhNo(newStd.getStdPhNo());
		
		stdRepository.save(existingStd);
		
		return stdConverter.convertEntityToStudentDto(existingStd);
	}

	@Override
	public void deleteStudentById(int id) {
		
		stdRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "id", id));
		
		stdRepository.deleteById(id);
		
	}

	@Override
	public StudentDto assignUniRollNo(int stdId) {
		
		Student std = stdRepository.findById(stdId).get();		
		if(std.getDepartment()!=null)
		{
			int deptId = std.getDepartment().getDeptId();
			int uniRoll = (deptId*1000) + stdId;
			std.setUniRoll(uniRoll);
			
			stdRepository.save(std);				
		}
		return stdConverter.convertEntityToStudentDto(std);	
	}

	@Override
	public List<StudentDto> getStudentByName(String name)
	{
		List<Student> students = stdRepository.findStudentByName(name);
		
		List<StudentDto> sDtos = new ArrayList<>();
		
		for(Student s : students)
		{
			sDtos.add(stdConverter.convertEntityToStudentDto(s));
		}
		
		return sDtos;
	}
	
	@Override
	public StudentDto getStudentByEmail(String email)
	{
		Student std = stdRepository.findByEmail(email);
				//.orElseThrow(()-> new ResourceNotFoundException("Student","email",email));
		
		return stdConverter.convertEntityToStudentDto(std);
	}

	@Override
	public List<StudentDto> getStudentByDeptName(String deptName) {
		
		List<Student> students = stdRepository.getStudentByDeptName(deptName);
		List<StudentDto> sDtos = new ArrayList<>();
		for(Student s : students)
		{
			sDtos.add(stdConverter.convertEntityToStudentDto(s));
		}		
		return sDtos;
	}
}