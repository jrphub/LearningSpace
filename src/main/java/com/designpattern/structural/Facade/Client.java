package com.designpattern.structural.Facade;

public class Client {
	public static void main(String[] args) {
		ATMFacade atm = new ATMFacade();

		long cash1 = atm.withdraw(900);
		System.out.println("Amount withdrawn : " + cash1); // 900

		long cash2 = atm.withdraw(200);
		System.out.println("Amount withdrawn : " + cash2); // 0

		long cash3 = atm.withdraw(100);
		System.out.println("Amount withdrawn : " + cash3); // 100
	}
}
