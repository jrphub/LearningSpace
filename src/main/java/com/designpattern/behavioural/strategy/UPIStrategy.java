package com.designpattern.behavioural.strategy;

public class UPIStrategy implements PaymentStrategy {
	@Override
	public void pay() {
		System.out.println("UPI payment");
	}
}
