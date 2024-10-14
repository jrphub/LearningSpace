package com.designpattern.structural.proxy;

public class EmployeeDaoProxy {
	EmployeeDao employeeDao;

	EmployeeDaoProxy() {
		employeeDao = new EmployeeDaoImpl();
	}

	void createEmployee() {
		employeeDao.create();
	}
}
