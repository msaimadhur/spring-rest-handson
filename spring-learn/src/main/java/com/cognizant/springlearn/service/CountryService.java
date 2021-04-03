package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.CountryList;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;


@Service
public class CountryService {
	public Country getCountry(String code) throws CountryNotFoundException 
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		CountryList countryList = (CountryList) context.getBean("countryList", CountryList.class);
		List<Country> list = countryList.getList();
		Country country = null;
		int i = 0;
		for(Country ct:list)
		{
			if(ct.getCode().equalsIgnoreCase(code))
			{
				country = ct;
				i+=1;
				break;
			}
		}

		if(i==0)
		{
			throw new CountryNotFoundException("Country not found");
		}
		return country;
	}

}
