package com.magister.slim.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.magister.slim.exception.InvalidHeaderFieldException;

@RestControllerAdvice
public class HandleException {

	@ExceptionHandler
	public ResponseEntity<String> handleInvalidHeaderFieldException(InvalidHeaderFieldException exception)
	{
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.PRECONDITION_FAILED);
	}
}
