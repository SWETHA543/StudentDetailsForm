package com.school.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.school.utility.ErrorStructure;

@RestControllerAdvice
public class ApplicationHandler {
	
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorStructure<String>> UserNotFoundById(StudentNotFoundException cnf) {
		ErrorStructure<String> es = new ErrorStructure<String>();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(cnf.getMessage()); // message whate we threw in service
		es.setErrordata(" student WITH GIVEN ID NOT PRESENT ");

		return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(StudentNotFoundByNameException.class)
	public ResponseEntity<ErrorStructure<String>> CompanyNotFoundById(StudentNotFoundByNameException cnf) {
		ErrorStructure<String> es = new ErrorStructure<String>();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(cnf.getMsg()); // message whate we threw in service
		es.setErrordata(" student WITH GIVEN ID NOT PRESENT ");

		return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.NOT_FOUND);

	}


}
