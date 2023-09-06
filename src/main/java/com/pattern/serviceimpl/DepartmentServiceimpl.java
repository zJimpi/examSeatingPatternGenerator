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

    @Autowired
    RollAssignedDeptRepository dRollRepository;

    @Override
    public DepartmentDto saveDepartment(Department dept) {
        // Save the department entity
        deptRepository.save(dept);

        // Initialize uniroll with 0 when the department is getting created
        RollAssignedDept dRoll = new RollAssignedDept();
        dRoll.setDept(dept);
        dRoll.setUniroll(0);

        // Save the associated RollAssignedDept entity
        dRollRepository.save(dRoll);

        // Convert and return the saved department as a DepartmentDto
        return deptConverter.convertEntityToDepartmentDto(dept);
    }

    @Override
    public DepartmentDto getDepartmentById(int id) {
        // Retrieve the department by its unique ID, or throw an exception if not found
        Department dept = deptRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student", "id", id));

        // Convert and return the retrieved department as a DepartmentDto
        return deptConverter.convertEntityToDepartmentDto(dept);
    }

    @Override
    public DepartmentDto updateDepartmentById(int id, Department newDept) {
        // Retrieve the existing department by its unique ID
        Department existingDept = deptRepository.findById(id).get();

        // Update the existing department with the new data
        existingDept.setDeptName(newDept.getDeptName());
        existingDept.setStudents(newDept.getStudents());

        // Save the updated department
        deptRepository.save(existingDept);

        // Convert and return the updated department as a DepartmentDto
        return deptConverter.convertEntityToDepartmentDto(existingDept);
    }

    @Override
    public void deleteDepartmentById(int id) {
        // Check if the department exists by its ID, or throw an exception if not found
        deptRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Department", "id", id));

        // Delete the department by its ID
        deptRepository.deleteById(id);
    }

    @Override
    public void assignStudentToDept(int stdId, int deptId) {
        // Retrieve the student and department by their respective IDs or throw exceptions if not found
        Student std = stdRepository.findById(stdId).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id", stdId));

        Department dept = deptRepository.findById(deptId).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id", deptId));

        // Assign the student to the department and update the total students in the department
        std.setDepartment(dept);
        dept.setTotalStudents(dept.getTotalStudents() + 1);

        // Save the updated student and department
        stdRepository.save(std);
        deptRepository.save(dept);
    }

    @Override
    public void assignSubjectsToDept(int subId, int deptId) {
        // Retrieve the subject and department by their respective IDs or throw exceptions if not found
        Subject subject = subRepository.findById(subId).orElseThrow(
                () -> new ResourceNotFoundException("Subject", "id", subId));

        Department dept = deptRepository.findById(deptId).orElseThrow(
                () -> new ResourceNotFoundException("Department", "id", deptId));

        // Assign the subject to the department
        subject.setDepartment(dept);

        // Save the updated subject and department
        subRepository.save(subject);
        deptRepository.save(dept);
    }

    @Override
    public DepartmentDto getDepartmentByName(String name) {
        // Retrieve the department by its name
        Department dept = deptRepository.findDepartmentByName(name);

        // Convert and return the retrieved department as a DepartmentDto
        return deptConverter.convertEntityToDepartmentDto(dept);
    }

    @Override
    public List<SubjectDto> generateExamRoutineByDeptId(int deptId) {
        // Retrieve subjects associated with the specified department
        List<Subject> subjects = subRepository.getSubjectByDeptId(deptId);
        List<SubjectDto> subDtos = new ArrayList<>();

        LocalDate today = LocalDate.now();

        for (Subject s : subjects) {
            // Calculate the day of the week and adjust if it's Sunday
            DayOfWeek dayOfWeek = today.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SUNDAY) {
                today = today.plusDays(1);
            }

            // Set the exam date for the subject, save it, and add to the list of SubjectDto
            s.setExamDate(today);
            subRepository.save(s);
            subRepository.flush();
            SubjectDto subDto = subConverter.convertEntityToSubjectDto(s);
            subDtos.add(subDto);

            // Increase the date by 2 days for the next subject
            today = today.plusDays(2);
        }
        return subDtos;
    }

    @Override
    public List<SubjectDto> getExamRoutineByDeptId(int deptId) {
        // Retrieve subjects associated with the specified department
        List<Subject> subjects = subRepository.getSubjectByDeptId(deptId);
        List<SubjectDto> subDtos = new ArrayList<>();

        for (Subject s : subjects) {
            // Convert and add the subjects to the list of SubjectDto
            SubjectDto subDto = subConverter.convertEntityToSubjectDto(s);
            subDtos.add(subDto);
        }

        return subDtos;
    }

    @Override
    public long getTotalNoOfDepartment() {
        // Count the total number of departments
        long deptCount = deptRepository.count();
        return deptCount;
    }

}