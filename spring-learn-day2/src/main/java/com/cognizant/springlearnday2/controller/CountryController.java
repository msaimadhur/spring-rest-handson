package com.cognizant.springlearnday2.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearnday2.dao.CountryList;
import com.cognizant.springlearnday2.model.Country;
import com.cognizant.springlearnday2.service.CountryService;
import com.cognizant.springlearnday2.service.exception.CountryNotFoundException;


@RestController
public class CountryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	@Autowired
	private CountryService countryService;
	@RequestMapping("/country")
	public Country getCountry() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		LOGGER.debug("Start");
		Country country = context.getBean("country", Country.class);
		LOGGER.debug("END");
		return country;
	}
	@GetMapping("/countries")
	public CountryList getAllCountries() {
		LOGGER.info("START");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		CountryList countryList = context.getBean("countryList", CountryList.class);
		LOGGER.info("END");
		return countryList;
	}
	
	@GetMapping("/country/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException
	{
		return this.countryService.getCountry(code);
	}
	@PostMapping("/countries")
	public void addCountry(@RequestBody @Valid Country country)
	{
		LOGGER.info("Started");
		countryService.addCountry(country);
		LOGGER.debug("Country:{}",country);
		LOGGER.info("After Adding Country");
		LOGGER.debug("List:{}",countryService.getAllCountries());		
		LOGGER.info("End");
		
	}

}
