package com.java8.javabrains;

public class RunnableExample {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside Runnable");
			}
		});

		thread.start();
		//As Runnable interface has only one method i.e. run
		//Runnable is Functional Interface
		Thread thread1 = new Thread(() -> System.out.println("Inside lambda"));
		thread1.start();
	}
}
