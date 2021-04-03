package com.cognizant.springlearnday2.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearnday2.dao.EmployeeDao;
import com.cognizant.springlearnday2.model.Employee;



@Service
public class EmployeeService {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
	private static EmployeeDao empDao = context.getBean("employeeList",EmployeeDao.class);
	
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> list = empDao.getList();
		return list;
	}
	
	public void updateEmployee(Employee employee)
	{
		empDao.UpdateEmployee(employee);
	}
	
	public void deleteEmployee(String id)
	{
		empDao.deleteEmployee(id);
	}

}
