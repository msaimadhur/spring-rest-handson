package com.cognizant.springlearnday2.dao;

import java.util.Iterator;
import java.util.List;

import com.cognizant.springlearnday2.model.Employee;

public class EmployeeDao {
	private static List<Employee> EMPLOYEE_LIST;

	public List<Employee> getList() {
		return EMPLOYEE_LIST;
	}

	public void setList(List<Employee> EMPLOYEE_LIST) {
		EmployeeDao.EMPLOYEE_LIST = EMPLOYEE_LIST;
	}

	public EmployeeDao() {
		super();
	}

	public EmployeeDao(List<Employee> EMPLOYEE_LIST) {
		super();
		EmployeeDao.EMPLOYEE_LIST = EMPLOYEE_LIST;
	}

	public void UpdateEmployee(Employee employee) {
		for (Employee emp : EMPLOYEE_LIST) {
			if (emp.getEmpId().equalsIgnoreCase(employee.getEmpId())) {
				emp.setPermanent(employee.getPermanent());
			}
		}
	}

	public void deleteEmployee(String id) {
		Iterator<Employee> iterator = EMPLOYEE_LIST.iterator();
		while (iterator.hasNext()) {
			Employee emp = (Employee) iterator.next();
			if (emp.getEmpId().equalsIgnoreCase(id)) {
				iterator.remove();
			}
		}
	}
}
