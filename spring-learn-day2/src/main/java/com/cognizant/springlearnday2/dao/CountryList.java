package com.cognizant.springlearnday2.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.springlearnday2.model.Country;

public class CountryList {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryList.class);

	private List<Country> list;

	public CountryList(List<Country> list) {
		super();
		this.list = list;
	}

	public List<Country> getList() {
		return list;
	}

	public void setList(List<Country> list) {
		this.list = list;
	}

	public CountryList() {
		super();
		LOGGER.debug("Inside CountryList Constructor");

	}

	@Override
	public String toString() {
		return "[CountryList =" + list + "]";
	}
	

}
