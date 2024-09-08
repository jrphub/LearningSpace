package com.designpattern.creational.abstractFactory;

public class EuropeSpecification implements CarSpecification {
	@Override
	public void display() {
		System.out.println("Displaying EU spec");
	}
}
