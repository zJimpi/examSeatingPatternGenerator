package com.pattern.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pattern.dto.RollAssignedDeptDto;
import com.pattern.entity.RollAssignedDept;

@Component // Indicates that this class is a Spring component and can be managed by the Spring container.
public class RollAssignedDeptConverter {

    // Converts a RollAssignedDept entity to a RollAssignedDeptDto (Data Transfer Object).
    public RollAssignedDeptDto convertEntityToRollAssignedDeptDto(RollAssignedDept dRoll) {
        RollAssignedDeptDto dRollDto = new RollAssignedDeptDto(); // Create a new RollAssignedDeptDto object.

        if (dRoll != null) { // Check if the input RollAssignedDept entity is not null.
            BeanUtils.copyProperties(dRoll, dRollDto); // Copy properties from the entity to the DTO.
        }

        return dRollDto; // Return the populated RollAssignedDeptDto.
    }

    // Converts a RollAssignedDeptDto (Data Transfer Object) to a RollAssignedDept entity.
    public RollAssignedDept convertRollAssignedDeptDtoToEntity(RollAssignedDeptDto dRollDto) {
        RollAssignedDept dRoll = new RollAssignedDept(); // Create a new RollAssignedDept entity.

        if (dRollDto != null) { // Check if the input RollAssignedDeptDto is not null.
            BeanUtils.copyProperties(dRollDto, dRoll); // Copy properties from the DTO to the entity.
        }

        return dRoll; // Return the populated RollAssignedDept entity.
    }
}