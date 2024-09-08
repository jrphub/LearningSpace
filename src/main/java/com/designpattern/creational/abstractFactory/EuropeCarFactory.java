package com.designpattern.creational.abstractFactory;

public class EuropeCarFactory implements CarFactory{
	@Override
	public Car createCar() {
		return new Hatchback();
	}

	@Override
	public CarSpecification createSpecification() {
		return new EuropeSpecification();
	}
}
