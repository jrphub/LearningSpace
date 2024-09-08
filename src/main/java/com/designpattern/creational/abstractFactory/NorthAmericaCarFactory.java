package com.designpattern.creational.abstractFactory;

public class NorthAmericaCarFactory implements CarFactory{
	@Override
	public Car createCar() {
		return new Sedan();
	}

	@Override
	public CarSpecification createSpecification() {
		return new NorthAmericaSpec();
	}
}
