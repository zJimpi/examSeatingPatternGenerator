package com.pattern.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.DepartmentDto;
import com.pattern.entity.Department;
import com.pattern.repository.DepartmentRepository;
import com.pattern.service.DepartmentService;
import com.pattern.util.DepartmentConverter;

@Service
public class DepartmentServiceimpl implements DepartmentService {

	@Autowired
	DepartmentRepository deptRepository;
	
	@Autowired
	DepartmentConverter deptConverter;
	
	@Override
	public DepartmentDto saveDepartment(Department dept) {
		
		deptRepository.save(dept);
		
		return deptConverter.convertEntityToDepartmentDto(dept);
	}

	@Override
	public DepartmentDto getDepartmentById(int id) {
		
		Department dept = deptRepository.findById(id).get();
		
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
		
		deptRepository.deleteById(id);
	}

}
