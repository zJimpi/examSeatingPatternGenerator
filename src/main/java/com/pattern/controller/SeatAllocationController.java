package com.pattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pattern.dto.SeatAllocationDto;
import com.pattern.entity.SeatAllocation;
import com.pattern.service.SeatAlllocationService;
import com.pattern.util.SeatAllocationConverter;

@RestController
public class SeatAllocationController {
	
	@Autowired
	SeatAllocationConverter seatAlloConverter;
	
	@Autowired
	SeatAlllocationService seatAlloService;
	
	@PostMapping("/saveSeatAllocation")
	public SeatAllocationDto saveSeatAllocation(@RequestBody SeatAllocationDto seatAlloDto)
	{
		SeatAllocation seatAllo = seatAlloConverter.convertSeatAllocationDtoToEntity(seatAlloDto);
		
		return seatAlloService.saveSeatAllocation(seatAllo);
	}
	
	@GetMapping("/getSeatAllocationById/{id}")
	public SeatAllocationDto getSeatAllocationById(@PathVariable("id") int id)
	{
		return seatAlloService.getSeatAllocationById(id);
	}

}
