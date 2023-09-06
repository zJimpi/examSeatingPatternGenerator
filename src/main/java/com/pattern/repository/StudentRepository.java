package com.pattern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pattern.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	//maybe not required????
	@Query("from Student where dept=:d and uniRoll=:r")
	Student getStudentBYUniRollAndDeptId(@Param("d") int deptId,@Param("r") int uniRoll);
	
	@Query("select max(s.classRoll) from Student s where department=(from Department e where e.deptId=:id)")
	int getclassRollByDept(@Param("id") int DeptId);
	
	
	//custom method to fecth student details belognigng to department by using deptid
	@Query("from Student where department=(from Department where deptId=:d)")
	List<Student> getStudentsByDeptId(@Param("d") int deptId);
}
