package com.pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pattern.entity.LastAssignedRollToDept;
import com.pattern.entity.Student;

public interface LastAssignedRollToDeptRepository extends JpaRepository<LastAssignedRollToDept, Integer> {
	
	@Query("from LastAssignedRollToDept where deptId=:d")
	Student getBYDeptId(@Param("d") int deptId);
	

}
