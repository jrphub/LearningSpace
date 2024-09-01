package com.designpattern.creational.factory.example2;

public class Ship implements Transport {
	@Override
	public void delivery() {
		System.out.println("Ship delivers cargo by Sea");
	}
}
