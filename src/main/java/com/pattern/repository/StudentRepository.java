package com.pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pattern.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
