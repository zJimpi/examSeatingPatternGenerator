package com.pattern.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pattern.dto.RollAssignedDeptDto;
import com.pattern.entity.RollAssignedDept;
import com.pattern.exception.ResourceNotFoundException;
import com.pattern.repository.RollAssignedDeptRepository;
import com.pattern.service.RollAssignedDeptService;
import com.pattern.util.RollAssignedDeptConverter;


@Service
public class RollAssignedDeptServiceImpl implements RollAssignedDeptService{

	 // Autowired to inject RollAssignedDeptRepository bean
    @Autowired
    RollAssignedDeptRepository dRollRepository;

    // Autowired to inject RollAssignedDeptConverter bean
    @Autowired
    RollAssignedDeptConverter dRollConverter;

    // Method to save a RollAssignedDept entity to the database and return a DTO
    @Override
    public RollAssignedDeptDto saveRollAssignedDept(RollAssignedDept dRoll) {
        // Save the RollAssignedDept entity using the repository
        dRollRepository.save(dRoll);
        
        // Convert the saved entity to a DTO using the converter
        return dRollConverter.convertEntityToRollAssignedDeptDto(dRoll);
    }

    // Method to retrieve a RollAssignedDept by its ID and return it as a DTO
    @Override
    public RollAssignedDeptDto getRollAssignedDeptById(int id) {
        // Find the RollAssignedDept entity by its ID in the repository
        RollAssignedDept dRoll = dRollRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("RollAssignedDept", "id", id));
        
        // Convert the found entity to a DTO using the converter
        return dRollConverter.convertEntityToRollAssignedDeptDto(dRoll);
    }

    // Method to update a RollAssignedDept by its ID and return it as a DTO
    @Override
    public RollAssignedDeptDto updateRollAssignedDeptById(int id, RollAssignedDept dRoll) {
        // Find the existing RollAssignedDept entity by its ID in the repository
        RollAssignedDept existingDRoll = dRollRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("rollAssignedDept", "id", id));
        
        // Update the properties of the existing entity with the new values
        existingDRoll.setUniroll(dRoll.getUniroll());
        
        // Save the updated entity back to the repository
        dRollRepository.save(existingDRoll);
        
        // Convert the updated entity to a DTO using the converter
        return dRollConverter.convertEntityToRollAssignedDeptDto(existingDRoll);
    }

    // Method to delete a RollAssignedDept by its ID
    @Override
    public void deleteRollAssignedDeptById(int id) {
    }

}
