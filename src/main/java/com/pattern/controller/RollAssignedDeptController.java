package com.pattern.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pattern.dto.RollAssignedDeptDto;
import com.pattern.entity.RollAssignedDept;
import com.pattern.service.RollAssignedDeptService;
import com.pattern.util.RollAssignedDeptConverter;


@RestController
public class RollAssignedDeptController {
	
	@Autowired
	RollAssignedDeptService dRollService;
	
	@Autowired
	RollAssignedDeptConverter dRollConverter;
	
	@PostMapping("/saveRollAssignedDept")
	public RollAssignedDeptDto saveRollAssignedDeptDetails(@Valid @RequestBody RollAssignedDeptDto dRollDto)
	{
		RollAssignedDept dRoll = dRollConverter.convertRollAssignedDeptDtoToEntity(dRollDto);
		
		return dRollService.saveRollAssignedDept(dRoll);
	}
	
	@GetMapping("/getRollAssignedDeptById/{id}")
	public RollAssignedDeptDto getRollAssignedDeptDetailsById(@PathVariable("id") int id)
	{
		return dRollService.getRollAssignedDeptById(id);
	}

	@PutMapping("/updateRollAssignedDept/{id}") //used for updating get and post mapping //diff b/w put:upadte all things patch :update only one parameter
	public RollAssignedDeptDto updateRollAssignedDept(@PathVariable("id") int stdId,@Valid @RequestBody RollAssignedDeptDto dRollDto)
	{
		final RollAssignedDept dRoll = dRollConverter.convertRollAssignedDeptDtoToEntity(dRollDto);
		return dRollService.updateRollAssignedDeptById(stdId, dRoll);
	}
}
