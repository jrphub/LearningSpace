package com.java8.in28minutes.java8;

import java.util.stream.IntStream;

public class FP08Thread {

	public static void main(String[] args) {
		/*Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i=0; i< 10; i++) {
					System.out.println(Thread.currentThread().getId() + ":" + i);
				}
			}
		};*/

		/*Runnable runnable = () -> {
			for (int i=0; i< 10; i++) {
				System.out.println(Thread.currentThread().getId() + ":" + i);
			}
		};*/

		Runnable runnable = () -> {
			IntStream.rangeClosed(1, 10).forEach(
				x -> System.out.println(Thread.currentThread().getId() + ":" + x));
		};

		Thread thread = new Thread(runnable);
		thread.start();

		Thread thread2 = new Thread(runnable);
		thread2.start();
	}
}
