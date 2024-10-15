package com.designpattern.behavioural.state;

public class Customer {

	public static void main(String[] args) {
		VendingMachineContext context = new VendingMachineContext();

		VendingMachineState state1 = new TakeCoinState();
		//Changing the state
		context.setState(state1);
		//behaviour will be changed
		context.doAction();

		VendingMachineState state2 = new ReleaseProductState();
		//Changing the state
		context.setState(state2);
		//behaviour will be changed
		context.doAction();
	}
}
