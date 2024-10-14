package com.designpattern.structural.bridge;

public class Client {
	public static void main(String[] args) {
		AbstractVehicle car = new Car(new ProduceWorkshop(), new AssembleWorkshop());
		car.manufacture();

		AbstractVehicle bike = new Bike(new ProduceWorkshop(), new AssembleWorkshop());
		bike.manufacture();
	}
}
