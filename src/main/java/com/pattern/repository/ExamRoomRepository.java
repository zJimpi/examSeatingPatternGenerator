package com.pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pattern.entity.ExamRoom;

public interface ExamRoomRepository extends JpaRepository<ExamRoom, Integer> {

}
