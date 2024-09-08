package com.designpattern.creational.singleton;

/**
 * <h3>Singleton design pattern</h3>
 * <br/>
 * <b>Objective</b> : To create only one instance of a class using Eager initialization
 * <p>
 * <b>Problem of this approach</b> : This wastes resources
 * if singleton instance creation is a heavy process
 * or
 * instance is never used by the client application
 *<br/>
 * <b>what's the Solution?</b> : Bill Pugh Singleton (Check next)
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
