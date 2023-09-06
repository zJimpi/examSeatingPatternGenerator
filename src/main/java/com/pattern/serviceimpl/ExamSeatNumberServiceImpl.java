package com.pattern.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.ExamSeatNumberDto;
import com.pattern.entity.Department;
import com.pattern.entity.ExamRoom;
import com.pattern.entity.ExamSeatNumber;
import com.pattern.entity.RollAssignedDept;
import com.pattern.entity.Student;
import com.pattern.exception.ResourceNotFoundException;
import com.pattern.repository.DepartmentRepository;
import com.pattern.repository.ExamRoomRepository;
import com.pattern.repository.ExamSeatNumberRepository;
import com.pattern.repository.RollAssignedDeptRepository;
import com.pattern.repository.StudentRepository;
import com.pattern.service.ExamSeatNumberService;
import com.pattern.service.RollAssignedDeptService;
import com.pattern.util.ExamSeatNumberConverter;

@Service
public class ExamSeatNumberServiceImpl implements ExamSeatNumberService {

	@Autowired
	ExamSeatNumberRepository seatRepository;

	@Autowired
	ExamSeatNumberConverter seatConverter;

	@Autowired
	ExamRoomRepository exRoomRepository;

	@Autowired
	DepartmentRepository deptRepository;

	@Autowired
	StudentRepository stdRepository;

	@Autowired
	RollAssignedDeptRepository dRollRepository;
	
	@Autowired
	RollAssignedDeptService dRollService;

	@Override
	public void saveExamSeatNumber(int roomId) {

		//ExamSeatNumber seat = new ExamSeatNumber();

		// get student
		// alternating students from different dept send room no

		ArrayList<ArrayList<Student>> stdSeats = sendAlternatingStudents(roomId);

		for (int i = 0; i < stdSeats.size() - 1; i++) {
			ArrayList<Student> row = stdSeats.get(i);
			for (int j = 0; j < row.size() - 1; j++) {
				
				ExamSeatNumber seat = new ExamSeatNumber();

				seat.setStd(stdSeats.get(i).get(j));

				// assign room no
				seat.setRoom(exRoomRepository.findById(roomId).get());

				// assign seat number
				int seatNo = roomId * 100 + i * 10 + j;
				// System.out.print(seatNo+" ");
				seat.setSeatNo(seatNo);

				seatRepository.save(seat);
			}
			// System.out.println();
		} // end of outer for loop

	}

	@Override
	public ExamSeatNumberDto getExamSeatNumberById(int id) {

		ExamSeatNumber seat = seatRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ExamSeatNumber", "id", id));
		return null;
	}

	@Override
	public ExamSeatNumberDto updateExamSeatNumberById(int id, ExamSeatNumber seat) {
		
		return null;
	}

	@Override
	public void deleteExamSeatNumberById(int id) {
		// TODO Auto-generated method stub

	}

	// pattern is gentarted
	public ArrayList<ArrayList<Student>> sendAlternatingStudents(int roomId) {
		// id is required
		ExamRoom room = exRoomRepository.findById(roomId).get();
		int totalSeat = room.getTotalSeats();

		// custom method in dept
		int countDepartment = deptRepository.getTotalNoOfDepartment();
		int col = countDepartment;
		int nearestWholeNum = totalSeat;
		// incase few colums have more seats than others the the small clo will have the
		// seat pattern genrated but not be assigned
		if (totalSeat % col != 0) {
			while (nearestWholeNum % col != 0) {
				nearestWholeNum++;
			}
		}

		int row = nearestWholeNum / col;

		// for stoping the loop after totalstudent have been assigned.
		int count = 0;

		ArrayList<ArrayList<Student>> seat = new ArrayList<>();

		// creat pattern and assing the seats as we cearte
		for (int i = 0; i <= row; i++) {
			ArrayList<Student> rowList = new ArrayList<>();
			for (int j = 0; j <= col; j++) {
				// creating alternating department ids
				int deptId = (i + j) % col + 1; // 1 2 3 4

				// assign student id from alternating depts to seats

				// fetching dept
				Department dept = deptRepository.findById(deptId)
						.orElseThrow(() -> new ResourceNotFoundException("Department", "id", roomId));// 1 //2

				if (dept != null) {
					// fetching students in the dept
					List<Student> students = stdRepository.getStudentsByDeptId(deptId);// 1

					if (students != null && !students.isEmpty()) {
						// last assigned roll from dept
						// initialize table values with 1 when the dept is getting created then update
						// them
						RollAssignedDept dRoll = dRollRepository.findById(deptId)
								.orElseThrow(() -> new ResourceNotFoundException("RollAssignedDept", "id", deptId));

						if (dRoll != null) {
							int lastRoll = dRoll.getUniroll();// dept=2 roll=1

							if (lastRoll < students.size()) {
								// adding students one by one
								rowList.add(students.get(lastRoll));

								//update uniroll  of roll assigned dept
								lastRoll++;
								
								dRoll.setUniroll(lastRoll);
								
								dRollRepository.save(dRoll);
								//save it in db
								//dRollService.updateRollAssignedDeptById(deptId, dRoll);

								count++;
								// loop bearks when all staets are assigned or all sutends of dept have been
								// assigned
								if (count == totalSeat || lastRoll == stdRepository.getclassRollByDept(deptId)) {

									break;
								} // if count end

							} // lastroll<student if end
						} // dRoll null if end
					} // rollassigned is null if end

				} // dept null if end

			} // for outer loop
			seat.add(rowList);
		}


		return seat;

	}

}
