package com.pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pattern.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
