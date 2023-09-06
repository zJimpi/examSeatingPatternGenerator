package com.pattern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pattern.entity.Department;
import com.pattern.entity.Student;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	@Query("select count(distinct d.deptId) from Department d")

	int findTotalNoOfDepartment();
	
	@Query("from Department where deptName=:e")
	Department findDepartmentByName(@Param("e") String name );

	int getTotalNoOfDepartment();
	
	
	//fetch students by department number
	@Query("from Student where dept=(from Department where deptId=:d)")
	List<Student> getStudentsByDeptId(@Param("d") int deptId);
}
