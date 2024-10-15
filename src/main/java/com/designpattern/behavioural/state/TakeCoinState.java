package com.designpattern.behavioural.state;

public class TakeCoinState implements VendingMachineState {
	@Override
	public void processRequest() {
		System.out.println("Insert coin");
	}
}
