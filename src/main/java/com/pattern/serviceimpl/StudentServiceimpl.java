package com.pattern.serviceimpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.StudentDto;
import com.pattern.entity.Department;
import com.pattern.entity.Student;
import com.pattern.exception.ResourceNotFoundException;
import com.pattern.repository.DepartmentRepository;
import com.pattern.repository.StudentRepository;
import com.pattern.service.StudentService;
import com.pattern.util.StudentConverter;


@Service
public class StudentServiceimpl implements StudentService{

	@Autowired
	StudentRepository stdRepository;
	
	@Autowired
	StudentConverter stdConverter;
	
	@Autowired
	DepartmentRepository deptRepository;
	
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
	public Student getStudentBYUniRollAndDeptId(int deptId, int uniRoll) {
		
		Student std = stdRepository.getStudentBYUniRollAndDeptId(deptId, uniRoll);
		
		return std;
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
	public int getLastRollOfDeptById(int deptId) {
		
		
		int id = stdRepository.getclassRollByDept(deptId);
		
		
		return id;
	}

	@Override
	public List<StudentDto> getStudentsByDeptId(int deptId) {
		
		List<Student> students =stdRepository.getStudentsByDeptId(deptId);
		
		List<StudentDto> sDtos = new ArrayList<>();
		
		for(Student s :students)
		{
			StudentDto sDto= stdConverter.convertEntityToStudentDto(s);
			sDtos.add(sDto);
		}
		
		
		return sDtos;
	}
}