package com.designpattern.behavioural.state;

public class VendingMachineContext {
	VendingMachineState state;

	public VendingMachineState getState() {
		return state;
	}

	public void setState(VendingMachineState state) {
		this.state = state;
	}

	void doAction() {
		state.processRequest();
	}
}
