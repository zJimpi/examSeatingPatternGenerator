package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.SeatAllocationDto;
import com.pattern.entity.SeatAllocation;

@Component
public class SeatAllocationConverter {

	public SeatAllocationDto convertEntityToSeatAllocationDto(SeatAllocation seatAllo)
	{
		SeatAllocationDto seatAlloDto =new SeatAllocationDto();
		
		if(seatAllo != null)
		{
			BeanUtils.copyProperties(seatAllo, seatAlloDto);
		}
		
		return seatAlloDto;
	}
	
	public SeatAllocation convertSeatAllocationDtoToEntity(SeatAllocationDto seatAlloDto)
	{
		SeatAllocation seatAllo =new SeatAllocation();
		if(seatAlloDto != null)
		{
			BeanUtils.copyProperties(seatAlloDto, seatAllo);
		}
		return seatAllo;
	}
	
}
