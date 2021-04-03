package com.cognizant.springlearnday2.dao;

import java.util.List;

import com.cognizant.springlearnday2.model.Department;


public class DepartmentDao {
	private List<Department> list;

	public List<Department> getList() {
		return list;
	}

	public void setList(List<Department> list) {
		this.list = list;
	}

	public DepartmentDao(List<Department> list) {
		super();
		this.list = list;
	}

	public DepartmentDao() {
		super();
	}
	

}
