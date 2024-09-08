package com.designpattern.creational.abstractFactory;

public class NorthAmericaSpec implements CarSpecification {
	@Override
	public void display() {
		System.out.println("Displaying NA spec");
	}
}
