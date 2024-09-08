package com.designpattern.creational.abstractFactory;

public class Sedan implements Car {
	@Override
	public void assemble() {
		System.out.println("Assembling a Sedan");
	}
}
