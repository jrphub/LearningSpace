package com.java8.udemy.java8plus.Bstreams;

import java.util.Optional;
import java.util.stream.Stream;

public class ETerminalOperationReduce {
	public static void main(String[] args) {
		Stream<String> companies1 = Stream.of("microsoft", "google", "amazon");
		String reduce = companies1.reduce("",
			(a, b) -> a + "-" + b // With Identity, accumulator
		);
		System.out.println(reduce);//-microsoft-google-amazon

		Stream<String> companies2 = Stream.of("microsoft", "google", "amazon");
		Optional<String> reduceOptional = companies2.reduce(
			(a, b) -> a + "-" + b // no identity, only accumulator // BiFunction
		);
		System.out.println(reduceOptional.orElse("no")); // microsoft-google-amazon

		Stream<String> companies3 = Stream.of("microsoft", "google", "amazon");
		//find the total no. of characters present in all companies
		Integer totalCount = companies3.reduce(0,
			(a, b) -> a + b.length(), // a is an integer // accumulator // BiFunction
			(x, y) -> x + y);// both are integers // combiner // Binary Operator
		System.out.println(totalCount); //21
	}
}
