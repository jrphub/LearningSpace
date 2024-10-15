package com.designpattern.behavioural.strategy;

public class Customer {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart(new CreditCardStrategy());
		cart.makePayment();
	}
}
