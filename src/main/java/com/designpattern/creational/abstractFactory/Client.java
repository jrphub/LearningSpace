package com.designpattern.creational.abstractFactory;

public class Client {
	public static void main(String[] args) {
		CarFactory naFactory = new NorthAmericaCarFactory();
		Car naCar = naFactory.createCar(); //Client doesn't know which type of car
		naCar.assemble();
		CarSpecification naSpecification = naFactory.createSpecification(); // Client doesn't know the specification
		naSpecification.display();

		CarFactory euFactory = new EuropeCarFactory();
		Car euCar = euFactory.createCar(); //Client doesn't know which type of car
		euCar.assemble();
		CarSpecification euSpecification = euFactory.createSpecification(); // Client doesn't know the specification
		euSpecification.display();
	}
}
