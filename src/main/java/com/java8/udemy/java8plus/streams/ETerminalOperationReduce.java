package com.java8.udemy.java8plus.streams;

import java.util.Optional;
import java.util.stream.Stream;

public class ETerminalOperationReduce {
	public static void main(String[] args) {
		Stream<String> companies1 = Stream.of("microsoft", "google", "amazon");
		String reduce = companies1.reduce("", (a, b) -> a + "-" + b);
		System.out.println(reduce);//-microsoft-google-amazon

		Stream<String> companies2 = Stream.of("microsoft", "google", "amazon");
		Optional<String> reduceOptional = companies2.reduce((a, b) -> a + "-" + b);
		System.out.println(reduceOptional.orElse("no")); // microsoft-google-amazon

		Stream<String> companies3 = Stream.of("microsoft", "google", "amazon");
		//find the no. of characters present in companies3
		Integer totalCount = companies3.reduce(0,
			(a, b) -> a + b.length(), // a is an integer
			(x, y) -> x + y);// both are integers
		System.out.println(totalCount); //21
	}
}
