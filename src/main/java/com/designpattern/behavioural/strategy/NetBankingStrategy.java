package com.designpattern.behavioural.strategy;

public class NetBankingStrategy implements PaymentStrategy {
	@Override
	public void pay() {
		System.out.println("Paying via internet banking");
	}
}
