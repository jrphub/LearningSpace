package com.designpattern.creational.factory.example2;

public class RoadLogistics extends AbstractLogistics {

	@Override
	Transport createTransport() {
		return new Truck();
	}
}
