package com.cognizant.springlearnday2.service.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@SuppressWarnings("serial")

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends Exception{
	public CountryNotFoundException(String s)
	{
		super(s);
	}


}
