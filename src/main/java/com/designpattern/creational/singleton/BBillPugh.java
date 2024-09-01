package com.designpattern.creational.singleton;

/**
 * Instead of intializing immediately, instance will be created using an inner class
 */
public class BBillPugh {
	//private constructor
	private BBillPugh() {
	}

	private static class BillPughHelper {
		private static final BBillPugh INSTANCE = new BBillPugh();
	}

	public static BBillPugh getInstance() {
		return BillPughHelper.INSTANCE;
	}


}
