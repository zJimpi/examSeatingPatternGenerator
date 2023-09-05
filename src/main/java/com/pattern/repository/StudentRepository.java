package com.pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pattern.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("from Student where dept=:d and uniRoll=:r")
	Student getStudentBYUniRollAndDeptId(@Param("d") int deptId,@Param("r") int uniRoll);
}
