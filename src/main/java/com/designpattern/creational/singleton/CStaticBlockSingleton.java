package com.designpattern.creational.singleton;

public class CStaticBlockSingleton {
	private static CStaticBlockSingleton instance;

	private CStaticBlockSingleton(){}

	static {
		try {
			instance = new CStaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured while creating singleton instance");
		}
	}

	public static CStaticBlockSingleton getInstance() {
		return instance;
	}
}
