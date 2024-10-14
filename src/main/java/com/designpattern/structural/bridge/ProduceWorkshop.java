package com.designpattern.structural.bridge;

public class ProduceWorkshop implements Workshop {
	@Override
	public void work() {
		System.out.println("Production completed.");
	}
}
