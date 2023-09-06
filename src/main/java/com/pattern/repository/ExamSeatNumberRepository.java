package com.pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pattern.entity.ExamSeatNumber;

public interface ExamSeatNumberRepository extends JpaRepository<ExamSeatNumber, Integer> {

}
