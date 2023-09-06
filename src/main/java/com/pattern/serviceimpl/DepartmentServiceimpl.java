package com.pattern.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.DepartmentDto;
import com.pattern.entity.Department;
import com.pattern.entity.RollAssignedDept;
import com.pattern.entity.Student;
import com.pattern.entity.Subject;
import com.pattern.exception.ResourceNotFoundException;
import com.pattern.repository.DepartmentRepository;
import com.pattern.repository.RollAssignedDeptRepository;
import com.pattern.repository.StudentRepository;
import com.pattern.repository.SubjectRepository;
import com.pattern.service.DepartmentService;
import com.pattern.util.DepartmentConverter;


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
	RollAssignedDeptRepository dRollRepository;
	
	@Override
	public DepartmentDto saveDepartment(Department dept) {
		
		deptRepository.save(dept);
		//initialiazing uniroll with 1 when the department is getting created
		RollAssignedDept dRoll =new RollAssignedDept();
		dRoll.setDept(dept);
		dRoll.setUniroll(0);
		
		dRollRepository.save(dRoll);
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
				()-> new ResourceNotFoundException("Student", "id", deptId));
		
		subject.setDepartment(dept);
		
		subRepository.save(subject);
		deptRepository.save(dept);	
	}

	@Override
	public long getTotalNoOfDepartment() {
		long deptCount =deptRepository.count();
		return deptCount;
	}
}