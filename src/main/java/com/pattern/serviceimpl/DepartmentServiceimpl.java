package com.pattern.serviceimpl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.DepartmentDto;
import com.pattern.dto.SubjectDto;
import com.pattern.entity.Department;
import com.pattern.entity.Student;
import com.pattern.entity.Subject;
import com.pattern.exception.ResourceNotFoundException;
import com.pattern.repository.DepartmentRepository;
import com.pattern.repository.StudentRepository;
import com.pattern.repository.SubjectRepository;
import com.pattern.service.DepartmentService;
import com.pattern.util.DepartmentConverter;
import com.pattern.util.SubjectConverter;



@Service
public class DepartmentServiceimpl implements DepartmentService {

	@Autowired
	DepartmentRepository deptRepository;
	
	@Autowired
	DepartmentConverter deptConverter;
	
	@Autowired
	StudentRepository stdRepository;
	
	@Autowired
	SubjectRepository subRepository;
	
	@Autowired
	SubjectConverter subConverter;
	
	@Override
	public DepartmentDto saveDepartment(Department dept) {
		
		deptRepository.save(dept);
		
		return deptConverter.convertEntityToDepartmentDto(dept);
	}

	@Override
	public DepartmentDto getDepartmentById(int id) {
		
		Department dept = deptRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "id", id));;
		
		return deptConverter.convertEntityToDepartmentDto(dept);
	}

	@Override
	public DepartmentDto updateDepartmentById(int id, Department newDept) {
		
		Department existingDept = deptRepository.findById(id).get();
		
		existingDept.setDeptName(newDept.getDeptName());
		existingDept.setStudents(newDept.getStudents());
		
		deptRepository.save(existingDept);
		
		return deptConverter.convertEntityToDepartmentDto(existingDept);
	}

	@Override
	public void deleteDepartmentById(int id) {
		
		deptRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Department", "id", id));
		
		deptRepository.deleteById(id);
	}

	@Override
	public void assignStudentToDept(int stdId, int deptId) {
		
		Student std = stdRepository.findById(stdId).orElseThrow(
				()-> new ResourceNotFoundException("Student", "id", stdId));
		
	Department dept = deptRepository.findById(deptId).orElseThrow(
			()-> new ResourceNotFoundException("Student", "id", deptId));
	
	std.setDepartment(dept);
	//update the total students
	dept.setTotalStudents(dept.getTotalStudents()+1);
	
	stdRepository.save(std);
	deptRepository.save(dept);
		
	}

	@Override
	public void assignSubjectsToDept(int subId, int deptId) {
		
		Subject subject = subRepository.findById(subId).orElseThrow(
				()-> new ResourceNotFoundException("Subject", "id",subId));
		
		Department dept = deptRepository.findById(deptId).orElseThrow(
				()-> new ResourceNotFoundException("Department", "id", deptId));
		
		subject.setDepartment(dept);
		
		subRepository.save(subject);
		deptRepository.save(dept);	
	}

	@Override
	public DepartmentDto getDepartmentByName(String name) {
		
		Department dept = deptRepository.findDepartmentByName(name);
		
		return deptConverter.convertEntityToDepartmentDto(dept);
	}

	@Override
	public List<SubjectDto> generateExamRoutineByDeptId(int deptId) {
		
		
		List<Subject> subjects = subRepository.getSubjectByDeptId(deptId);
		List<SubjectDto> subDtos = new ArrayList<>();
		
		LocalDate today = LocalDate.now();
		
		for(Subject s : subjects)
		{
			DayOfWeek dayOfWeek = today.getDayOfWeek();
			if (dayOfWeek == DayOfWeek.SUNDAY) 
			{
				today = today.plusDays(1);
			}
			s.setExamDate(today);
			subRepository.save(s);
			subRepository.flush();
			SubjectDto subDto= subConverter.convertEntityToSubjectDto(s);
			subDtos.add(subDto);
			today = today.plusDays(2);
		}
		return subDtos;
	}

	@Override
	public List<SubjectDto> getExamRoutineByDeptId(int deptId) {
		
		List<Subject> subjects = subRepository.getSubjectByDeptId(deptId);
		
		List<SubjectDto> subDtos = new ArrayList<>();
		
		for(Subject s :subjects)
		{
			SubjectDto subDto= subConverter.convertEntityToSubjectDto(s);
			subDtos.add(subDto);
		}
		
		return subDtos;
	}
}