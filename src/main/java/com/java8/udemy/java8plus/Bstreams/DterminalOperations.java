package com.java8.udemy.java8plus.Bstreams;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DterminalOperations {

	public static void main(String[] args) {
		//Terminal Operations : count(), min(), max(), findAny(), findFirst(), anyMatch(), allMatch(), noneMatch(), forEach()
		streamCount();

		streamMin();

		streamMax();

		streamMatch();

		streamAny();

		streamForEach();
	}

	private static void streamForEach() {
		Stream<String> companies1 = Stream.of("microsoft", "google", "amazon");
		companies1.forEach(System.out::println);
	}

	private static void streamAny() {
		Stream<String> companies1 = Stream.of("microsoft", "google", "amazon");
		companies1.findAny().ifPresent(System.out::println); //microsoft
		Stream<String> companies2 = Stream.of("microsoft", "google", "amazon");
		companies2.findFirst().ifPresent(System.out::println); //microsoft
	}

	private static void streamMatch() {
		Stream<String> companies1 = Stream.of("microsoft", "google", "amazon");
		Predicate<String> pred = name -> name.startsWith("a");
		System.out.println(companies1.anyMatch(pred));//true
		Stream<String> companies2 = Stream.of("microsoft", "google", "amazon");
		System.out.println(companies2.allMatch(pred));//false
		Stream<String> companies3 = Stream.of("microsoft", "google", "amazon");
		System.out.println(companies3.noneMatch(pred));//false
	}

	private static void streamMax() {
		Stream<String> companies = Stream.of("microsoft", "google", "amazon");
		Optional<String> max = companies.max((s1, s2) -> s1.length() - s2.length());
		max.ifPresent(System.out::println); //microsoft
		System.out.println("company : " + (max.orElse("no company found"))); //company : microsoft
	}

	private static void streamMin() {
		Stream<String> companies = Stream.of("microsoft", "google", "amazon");
		Optional<String> min = companies.min((s1, s2) -> s1.length() - s2.length());
		min.ifPresent(System.out::println); //google
		System.out.println("company : " + (min.orElse("no company found")));
		//company : google
	}

	private static void streamCount() {
		Stream<String> companies = Stream.of("microsoft", "google", "amazon");
		long count = companies.count();
		System.out.println("Company count : " + count);
		//Company count : 3
	}
}
