package com.pattern.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.StudentDto;
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
	
	

}
