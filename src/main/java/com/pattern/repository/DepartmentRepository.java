package com.pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pattern.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
