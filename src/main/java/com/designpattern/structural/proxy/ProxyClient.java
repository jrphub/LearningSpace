package com.designpattern.structural.proxy;

public class ProxyClient {

	public static void main(String[] args) {
		EmployeeDaoProxy proxy = new EmployeeDaoProxy();
		proxy.createEmployee();
	}
}
