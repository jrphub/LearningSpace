package com.designpattern.creational.factory.example2;

public class SeaLogistics extends AbstractLogistics {

	@Override
	Transport createTransport() {
		return new Ship();
	}
}
