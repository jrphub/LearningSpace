package com.designpattern.behavioural.strategy;

public class CreditCardStrategy implements PaymentStrategy {
	@Override
	public void pay() {
		System.out.println("Paying via Credit Card");
	}
}
