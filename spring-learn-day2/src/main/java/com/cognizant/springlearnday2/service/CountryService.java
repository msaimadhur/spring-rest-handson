package com.cognizant.springlearnday2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearnday2.dao.CountryList;
import com.cognizant.springlearnday2.model.Country;
import com.cognizant.springlearnday2.service.exception.CountryNotFoundException;


@Service
public class CountryService {	

	private static Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
	private static final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	private static CountryList countriesBean = context.getBean("countryList",CountryList.class);
	private List<Country> countryList =  countriesBean.getList();
	public Country getCountry(String code) throws CountryNotFoundException
	{
		LOGGER.info("Started Get Country");
		for(Country con : countryList)
		{
			if(con.getCode().equalsIgnoreCase(code))
					{
					LOGGER.debug("Country:{}",con);
					LOGGER.info("End");
					return con;
					}
		}
		throw new CountryNotFoundException("Country Not Found");
	}
	
	
	public List<Country> getAllCountries()
	{
		return countryList;
	}
	
	public void addCountry(Country country)
	{
		LOGGER.info("Started");
		
		if(country!= null)
		{
			countryList.add(country);
		}
		LOGGER.info("End");
		
		
	}

}
