package com.pattern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pattern.entity.Department;
import com.pattern.entity.Student;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	//Custom query to find the total number of distinct departments in the database.
	@Query("select count(distinct d.deptId) from Department d")
    int findTotalNoOfDepartment();

	//int findTotalNoOfDepartment();

	
	//Custom query to find a Department entity by its name.
	@Query("from Department where deptName=:e")
	Department findDepartmentByName(@Param("e") String name );
<<<<<<< HEAD


	//int getTotalNoOfDepartment();

	//Custom method to find the total number of departments without using a query.
	//int getTotalNoOfDepartment();
=======
>>>>>>> 748bbd2c62b588bd1ab6e87d26187f0537bb5257
	
	//Custom query to fetch students belonging to a specific department by department number.
	@Query("from Student where dept=(from Department where deptId=:d)")
	List<Student> getStudentsByDeptId(@Param("d") int deptId);
}
