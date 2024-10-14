package com.designpattern.structural.bridge;

public class Bike extends AbstractVehicle {
	Bike(Workshop workshop1, Workshop workshop2) {
		super(workshop1, workshop2);
	}

	@Override
	void manufacture() {
		System.out.println("Bike");
		workshop1.work();
		workshop2.work();
	}
}
