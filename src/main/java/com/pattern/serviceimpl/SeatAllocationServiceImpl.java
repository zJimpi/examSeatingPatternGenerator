package com.pattern.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.entity.Room;
import com.pattern.entity.Student;
import com.pattern.repository.DepartmentRepository;
import com.pattern.repository.RoomRepository;
import com.pattern.repository.StudentRepository;
import com.pattern.service.SeatAlllocationService;

@Service
public class SeatAllocationServiceImpl implements SeatAlllocationService{

	@Autowired
	StudentRepository stdRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	DepartmentRepository deptRepository;
	
	@Override
	public  ArrayList<ArrayList<Integer>> patternGeneration(Student std,int roomId) {
	    
		int totalSeat = roomRepository.findNoOfSeatByRoomId(roomId);
	    int countDepartment = deptRepository.findTotalNoOfDepartment();
	    
	    int row = countDepartment;
	    int nearestWholeNum = totalSeat;

	    if (totalSeat % row != 0) {
	        while (nearestWholeNum % row != 0) {
	            nearestWholeNum++;
	        }
	    }

	    int col = nearestWholeNum / row;

	    ArrayList<ArrayList<Integer>> seat = new ArrayList<>();

	    for (int i = 0; i < row; i++) {
	        ArrayList<Integer> rowList = new ArrayList<>();
	        for (int j = 0; j < col; j++) {
	            rowList.add(0); //assign diferent dept sstudent to seats
	        }
	        seat.add(rowList);
	    }

	    for (int i = 0; i < row; i++) {
	        for (int j = 0; j < col; j++) {
	            System.out.print(" " + seat.get(i).get(j));
	        }
	        System.out.println();
	    }

	    return seat;
	}


}
