package com.designpattern.structural.Facade;

public class ATMFacade {
	private AccountDao accountDao = new AccountDao();

	public long withdraw(long amount) {
		return accountDao.withdraw(amount);
	}
}
