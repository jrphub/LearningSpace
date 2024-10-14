package com.designpattern.structural.bridge;

public abstract class AbstractVehicle {
	Workshop workshop1;
	Workshop workshop2;

	AbstractVehicle(Workshop workshop1, Workshop workshop2) {
		this.workshop1 = workshop1;
		this.workshop2 = workshop2;
	}

	abstract void manufacture();
}
