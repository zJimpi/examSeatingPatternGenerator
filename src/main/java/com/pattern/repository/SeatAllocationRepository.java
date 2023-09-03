package com.pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pattern.entity.SeatAllocation;

public interface SeatAllocationRepository extends JpaRepository<SeatAllocation, Integer> {

}
