package com.pattern.exception;

import java.util.Date;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException ex,WebRequest request)
	{
        // Create an ErrorDetails object with timestamp, error message, and request description.
		ErrorDetails errors =new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
        
		// Return a ResponseEntity with the error details and HTTP status code NOT_FOUND.																		//false=short description
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
		
	}
	
	public ResponseEntity<?> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request)
	{
        // Create an ErrorDetails object with timestamp, error message, and request description.
		ErrorDetails errors = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		
        // Return a ResponseEntity with the error details and HTTP status code OK.
		return new ResponseEntity<>(errors, HttpStatus.OK);
	}
}
