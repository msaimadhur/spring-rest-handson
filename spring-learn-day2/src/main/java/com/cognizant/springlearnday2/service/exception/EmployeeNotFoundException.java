package com.cognizant.springlearnday2.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Employee Not Found")
public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException()
	{
		super();
	}

}
