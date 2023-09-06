package com.pattern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pattern.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	//Custom query to fetch subjects belonging to a department by department ID.
	@Query("from Subject where department=(from Department where deptId=:id)")
	List<Subject> getSubjectByDeptId(@Param("id") int deptId);
}