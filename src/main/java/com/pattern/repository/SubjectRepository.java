package com.pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pattern.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
