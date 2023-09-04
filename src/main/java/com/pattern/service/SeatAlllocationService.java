package com.pattern.service;

import java.util.ArrayList;

import com.pattern.entity.Room;
import com.pattern.entity.Student;

public interface SeatAlllocationService {
	
	//assigning seat number to students
	ArrayList<ArrayList<Integer>> patternGeneration(Student std,Room room);
	

}
