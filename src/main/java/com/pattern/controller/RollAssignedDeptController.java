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
	RollAssignedDeptService dRollService;  // Autowired service for managing RollAssignedDept details.

	@Autowired
	RollAssignedDeptConverter dRollConverter;  // Autowired converter for converting RollAssignedDept data.

	// Method to save RollAssignedDept details.
	@PostMapping("/saveRollAssignedDept")
	public RollAssignedDeptDto saveRollAssignedDeptDetails(@Valid @RequestBody RollAssignedDeptDto dRollDto)
	{
		// Convert the DTO (Data Transfer Object) to an entity object.
		RollAssignedDept dRoll = dRollConverter.convertRollAssignedDeptDtoToEntity(dRollDto);

		// Save the RollAssignedDept details and return the saved DTO.
		return dRollService.saveRollAssignedDept(dRoll);
	}

	// Method to retrieve RollAssignedDept details by ID.
	@GetMapping("/getRollAssignedDeptById/{id}")
	public RollAssignedDeptDto getRollAssignedDeptDetailsById(@PathVariable("id") int id)
	{
		// Retrieve RollAssignedDept details by ID and return the DTO.
		return dRollService.getRollAssignedDeptById(id);
	}

	// Method to update RollAssignedDept details by ID.
	@PutMapping("/updateRollAssignedDept/{id}")
	public RollAssignedDeptDto updateRollAssignedDept(@PathVariable("id") int stdId, @Valid @RequestBody RollAssignedDeptDto dRollDto)
	{
		// Convert the DTO to an entity object and update RollAssignedDept details by ID.
		final RollAssignedDept dRoll = dRollConverter.convertRollAssignedDeptDtoToEntity(dRollDto);
		return dRollService.updateRollAssignedDeptById(stdId, dRoll);
	}
}
