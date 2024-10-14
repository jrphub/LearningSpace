package com.designpattern.structural.proxy;

public class EmployeeDaoImpl implements EmployeeDao {
	@Override
	public void create() {
		System.out.println("Connecting Employee Dao via EmployeeDaoImpl");
	}
}
