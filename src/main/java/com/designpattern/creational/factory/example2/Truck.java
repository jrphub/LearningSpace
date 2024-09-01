package com.designpattern.creational.factory.example2;

public class Truck implements Transport {
	@Override
	public void delivery() {
		System.out.println("Truck delivers cargo by land");
	}
}
