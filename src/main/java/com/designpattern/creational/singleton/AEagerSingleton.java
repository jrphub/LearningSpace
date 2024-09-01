package com.designpattern.creational.singleton;

/**
 * Singleton design pattern
 * Objective : To create only one instance of a class
 * <p>
 * Problem : waste resources
 * if singleton instance creation is a heavy process
 * or
 * instance is never used by the client application
 *
 * Solution : Bill Pugh Singleton
 */
public class AEagerSingleton {

	// instance created immediately
	private static final AEagerSingleton instance = new AEagerSingleton();

	//private constructor
	private AEagerSingleton() {
	}

	//Public method to get the instance
	public static AEagerSingleton getInstance() {
		return instance;
	}

	//To protect from ClientHackerOne who uses Serialization to create multiple instance
	protected Object readResolve() {
		return instance;
	}
}
