package com.pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pattern.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	@Query("select count(distinct d.deptId) from Department d")
	int findTotalNoOfDepartment();

}
