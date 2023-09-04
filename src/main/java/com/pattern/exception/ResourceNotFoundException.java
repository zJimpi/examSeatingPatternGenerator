package com.pattern.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	private String resourceName;

	//eg: name,roll.. dept_name
	private String feildName;
	
	//eg: bca bba,99 ,sangita
	private Object feildValue;
	
	
	public ResourceNotFoundException(String resourceName, String feildName, Object feildValue) {
		super(String.format("%s not found with %s : '%s'",resourceName,feildName,feildValue));
		this.resourceName = resourceName;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}
}
