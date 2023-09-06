package com.pattern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pattern.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	//Custom query to find students by their name.
	@Query("from Student where stdName=:e")
	List<Student> findStudentByName(@Param("e") String name );
	
	//Custom query to find a student by their email.
	@Query("from Student where stdEmail=:e")
	Student findByEmail(@Param("e")String email);
	
	//custom method to fetch student details belonging to a department by using department id
	@Query("from Student where department=(from Department where deptName=:name)")
	List<Student> getStudentByDeptName(@Param("name")String deptName);


	//Custom query to fetch students' details belonging to a department by department name.
	@Query("from Student where dept=:d and uniRoll=:r")
	Student getStudentBYUniRollAndDeptId(@Param("d") int deptId,@Param("r") int uniRoll);
	
	@Query("select max(s.classRoll) from Student s where department=(from Department e where e.deptId=:id)")
	int getclassRollByDept(@Param("id") int DeptId);
	
	
	//custom method to fetch student details belonging to department by using deptid
	@Query("from Student where department=(from Department where deptId=:d)")
	List<Student> getStudentsByDeptId(@Param("d") int deptId);
}