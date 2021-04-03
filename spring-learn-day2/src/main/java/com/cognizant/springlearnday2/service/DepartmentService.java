package com.cognizant.springlearnday2.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearnday2.dao.DepartmentDao;
import com.cognizant.springlearnday2.model.Department;



@Service
public class DepartmentService {
	
	public List<Department> getAllDepartment()
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		DepartmentDao depDao = context.getBean("deptList", DepartmentDao.class);
		List<Department> list = depDao.getList();
		return list;
	}

}
