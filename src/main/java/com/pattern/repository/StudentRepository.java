package com.pattern.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pattern.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("from Student where stdName=:e")
	List<Student> findStudentByName(@Param("e") String name );
	
	@Query("from Student where stdEmail=:e")
	Student findByEmail(@Param("e")String email);
	
	//custom method to fetch student details belonging to a department by using department id
	@Query("from Student where department=(from Department where deptName=:name)")
	List<Student> getStudentByDeptName(@Param("name")String deptName);
}