package com.designpattern.behavioural.state;

public class ReleaseProductState implements VendingMachineState {
	@Override
	public void processRequest() {
		System.out.println("Releasing product");
	}
}
