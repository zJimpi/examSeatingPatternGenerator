package com.pattern.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.SeatAllocationDto;
import com.pattern.entity.Department;
import com.pattern.entity.Room;
import com.pattern.entity.SeatAllocation;
import com.pattern.entity.Student;
import com.pattern.repository.DepartmentRepository;
import com.pattern.repository.LastAssignedRollToDeptRepository;
import com.pattern.repository.RoomRepository;
import com.pattern.repository.SeatAllocationRepository;
import com.pattern.repository.StudentRepository;
import com.pattern.service.SeatAlllocationService;
import com.pattern.util.SeatAllocationConverter;

@Service
public class SeatAllocationServiceImpl implements SeatAlllocationService{

	@Autowired
	StudentRepository stdRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	DepartmentRepository deptRepository;
	
	@Autowired
	LastAssignedRollToDeptRepository lUnirollToDeptRepository;
	
	@Autowired
	SeatAllocationRepository seatAlloRepository;
	
	@Autowired
	SeatAllocationConverter seatAlloConverter;
	
	@Override
	public  ArrayList<ArrayList<Integer>> savePatternGeneration(SeatAllocation seatAllo,int roomId) {
	    
		int totalSeat = roomRepository.findNoOfSeatByRoomId(roomId);
	    int countDepartment = deptRepository.findTotalNoOfDepartment();
	    
	    int col = countDepartment;
	    int nearestWholeNum = totalSeat;

	    if (totalSeat % col != 0) {
	        while (nearestWholeNum % col != 0) {
	            nearestWholeNum++;
	        }
	    }

	    int row = nearestWholeNum /col;

	    ArrayList<ArrayList<Integer>> seat = new ArrayList<>();

	    for (int i = 0; i < row; i++) {
	        ArrayList<Integer> rowList = new ArrayList<>();
	        for (int j = 0; j < col; j++) {
	        	int deptId = (i + j) % col + 1;//alternatingly sending the id
	        	int uniRoll = lUnirollToDeptRepository.getBYDeptId(deptId).getUniRoll();
	        	Student student =stdRepository.getStudentBYUniRollAndDeptId(deptId, uniRoll);
	            rowList.add(student.getUniRoll()); //assign diferent dept sstudent to seats
	        }
	        seat.add(rowList);
	    }

//	    for (int i = 0; i < row; i++) {
//	        for (int j = 0; j < col; j++) {
//	            System.out.print(" " + seat.get(i).get(j));
//	        }
//	        System.out.println();
//	    }
	    
	    //seatAlloRepository.get
	    
	    seatAllo.setRoomPattern(seat);
	    seatAlloRepository.save(seatAllo);
	    
	    
	    
	    return seat;
	}

	@Override
	public SeatAllocationDto saveSeatAllocation(SeatAllocation seatAllo) {
		
		seatAlloRepository.save(seatAllo);
		
		return seatAlloConverter.convertEntityToSeatAllocationDto(seatAllo);
	}

	@Override
	public SeatAllocationDto updateSeatAllocationById(int id, SeatAllocation seatAllo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SeatAllocationDto getSeatAllocationById(int id) {
		SeatAllocation seatAllo =seatAlloRepository.findById(id).get();
		return seatAlloConverter.convertEntityToSeatAllocationDto(seatAllo);
	}

	@Override
	public void deleteSeatAlllocationById(int id) {
		// TODO Auto-generated method stub
		
	}

	

	

}
