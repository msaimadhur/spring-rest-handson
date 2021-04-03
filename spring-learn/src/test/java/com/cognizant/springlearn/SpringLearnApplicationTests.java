package com.cognizant.springlearn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNotNull;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.springlearn.controller.CountryController;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {
	@Autowired
	private CountryController countryController;
	@Autowired
	private MockMvc mvc;

	@Test
    public void contextLoads()
	{
		Assertions.assertNotNull(countryController);
	}
	
	@Test
	public void testGetCountry() throws Exception 
	{
		ResultActions actions = mvc.perform(get("/country"));
		actions.andExpect(status().isOk());
		
		actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$.code").value("IN"));
		
		//Using above two steps include checks for "name" attribute and check if it's value is "India"
		actions.andExpect(jsonPath("$.name").exists());
		actions.andExpect(jsonPath("$.name").value("India"));
	}
	
	@Test
	public void testGetCountryException() throws Exception
	{
		ResultActions actions = mvc.perform(get("/country/ak"));
//		actions.andExpect(status().isOk());
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Country not found"));
	}
}
