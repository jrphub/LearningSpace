package com.designpattern.structural.Facade;

public class AccountDao {

	private static long balance = 1000L;

	boolean isBalanceAvailable(long amount) {
		long balance = fetchBalance();
		if (balance >= amount) {
			return true;
		}
		return false;
	}

	private long fetchBalance() {
		return balance;
	}

	long withdraw(long amount) {
		if (isBalanceAvailable(amount)) {
			updateBalance(amount);
			return amount;
		}
		return 0;
	}

	private void updateBalance(long amount) {
		balance = balance - amount;
	}

}
