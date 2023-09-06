package com.pattern.serviceimpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.StudentDto;

import com.pattern.dto.SubjectDto;

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
	    // Custom method for generating university roll number (if any)
	    
	    // Save the student to the repository
	    stdRepository.save(std);
	    
	    // Convert the saved student entity to a StudentDto and return it
	    return stdConverter.convertEntityToStudentDto(std);
	}

	@Override
	public StudentDto getStudentById(int id) {
	    // Retrieve the student from the repository by its ID, or throw a ResourceNotFoundException if not found
	    Student std = stdRepository.findById(id).orElseThrow(() ->
	        new ResourceNotFoundException("Student", "id", id));
	    
	    // Convert the retrieved student entity to a StudentDto and return it
	    return stdConverter.convertEntityToStudentDto(std);
	}

	@Override
	public StudentDto updateStudentById(int id, Student newStd) {
	    // Retrieve the existing student from the repository by its ID
	    Student existingStd = stdRepository.findById(id).get();
	    
	    // Update the student's name, email, and phone number with the new values provided
	    existingStd.setStdName(newStd.getStdName());
	    existingStd.setStdEmail(newStd.getStdEmail());
	    existingStd.setStdPhNo(newStd.getStdPhNo());
	    
	    // Save the updated student entity to the repository
	    stdRepository.save(existingStd);
	    
	    // Convert the updated student entity to a StudentDto and return it
	    return stdConverter.convertEntityToStudentDto(existingStd);
	}

	@Override
	public void deleteStudentById(int id) {
	    // Check if the student with the given ID exists, or throw a ResourceNotFoundException if not found
	    stdRepository.findById(id).orElseThrow(() ->
	        new ResourceNotFoundException("Student", "id", id));
	    
	    // Delete the student from the repository by its ID
	    stdRepository.deleteById(id);
	}

	@Override
	public Student getStudentBYUniRollAndDeptId(int deptId, int uniRoll) {
	    // Retrieve a student by their university roll number and department ID from the repository
	    Student std = stdRepository.getStudentBYUniRollAndDeptId(deptId, uniRoll);
	    
	    // Return the retrieved student entity
	    return std;
	}

	@Override
	public StudentDto assignUniRollNo(int stdId) {
	    // Retrieve the student by their ID
	    Student std = stdRepository.findById(stdId).get();
	    
	    // Check if the student's department is not null
	    if (std.getDepartment() != null) {
	        int deptId = std.getDepartment().getDeptId();
	        int uniRoll = (deptId * 1000) + stdId;
	        std.setUniRoll(uniRoll);
	        
	        // Save the updated student entity with the university roll number
	        stdRepository.save(std);
	    }
	    
	    // Convert the updated student entity to a StudentDto and return it
	    return stdConverter.convertEntityToStudentDto(std);
	}

	@Override
	public List<StudentDto> getStudentByName(String name) {
	    // Retrieve a list of students by their name from the repository
	    List<Student> students = stdRepository.findStudentByName(name);
	    
	    // Initialize a list to store StudentDto objects
	    List<StudentDto> sDtos = new ArrayList<>();
	    
	    // Convert each student entity to a StudentDto and add it to the list
	    for (Student s : students) {
	        sDtos.add(stdConverter.convertEntityToStudentDto(s));
	    }
	    
	    // Return the list of StudentDto objects
	    return sDtos;
	}

	@Override
	public StudentDto getStudentByEmail(String email) {
	    // Retrieve a student by their email address from the repository
	    Student std = stdRepository.findByEmail(email);
	    
	    // Convert the retrieved student entity to a StudentDto and return it
	    return stdConverter.convertEntityToStudentDto(std);
	}

	@Override
	public List<StudentDto> getStudentByDeptName(String deptName) {
	    // Retrieve a list of students by department name from the repository
	    List<Student> students = stdRepository.getStudentByDeptName(deptName);
	    
	    // Initialize a list to store StudentDto objects
	    List<StudentDto> sDtos = new ArrayList<>();
	    
	    // Convert each student entity to a StudentDto and add it to the list
	    for (Student s : students) {
	        sDtos.add(stdConverter.convertEntityToStudentDto(s));
	    }
	    
	    // Return the list of StudentDto objects
	    return sDtos;
	}

	public int getLastRollOfDeptById(int deptId) {
	    // Retrieve the last class roll number of students in a department by department ID
	    int id = stdRepository.getclassRollByDept(deptId);
	    
	    // Return the last class roll number
	    return id;
	}

	@Override
	public List<StudentDto> getStudentsByDeptId(int deptId) {
	    // Retrieve a list of students by department ID from the repository
	    List<Student> students = stdRepository.getStudentsByDeptId(deptId);
	    
	    // Initialize a list to store StudentDto objects
	    List<StudentDto> sDtos = new ArrayList<>();
	    
	    // Convert each student entity to a StudentDto and add it to the list
	    for (Student s : students) {
	        StudentDto sDto = stdConverter.convertEntityToStudentDto(s);
	        sDtos.add(sDto);
	    }
	    
	    // Return the list of StudentDto objects
	    return sDtos;
	}

}