package com.designpattern.behavioural.strategy;

public class ShoppingCart {
	PaymentStrategy paymentStrategy;

	ShoppingCart(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	void makePayment() {
		paymentStrategy.pay();
	}
}
