package com.java8.in28minutes.java8;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03BehaviourParameterization {

	public static void main(String[] args) {
		List<Integer> numList = List.of(23, 45, 34, 69, 26, 36);
		//Approach - 1
		//print even numbers
		/*System.out.println("Printing even numbers in the list");
		numList.stream()
			.filter(x -> x%2 == 0)
			.forEach(System.out::println);*/

		// print odd numbers
		/*System.out.println("printing odd numbers in the list");
		numList.stream()
			.filter(x -> x%2 != 0)
			.forEach(System.out::println);*/

		//Approach - 2
		/*System.out.println("Printing even numbers in the list");
		Predicate<Integer> evenPredicate = x -> x % 2 == 0;
		numList.stream()
			.filter(evenPredicate)
			.forEach(System.out::println);

		System.out.println("printing odd numbers in the list");
		Predicate<Integer> oddPredicate = x -> x % 2 != 0;
		numList.stream()
			.filter(oddPredicate)
			.forEach(System.out::println);*/

		//Approach - 3
		/*System.out.println("Printing even numbers in the list");
		Predicate<Integer> evenPredicate = x -> x % 2 == 0;
		filterAndPrint(numList, evenPredicate);

		System.out.println("printing odd numbers in the list");
		Predicate<Integer> oddPredicate = x -> x % 2 != 0;
		filterAndPrint(numList, oddPredicate);*/

		//Approach - 4
		System.out.println("Printing even numbers in the list");
		filterAndPrint(numList, x -> x % 2 == 0); // we are passing behaviour or logic here

		System.out.println("printing odd numbers in the list");
		filterAndPrint(numList, x -> x % 2 != 0);

		System.out.println("printing all numbers divisble by 3 in the list");
		filterAndPrint(numList, x -> x % 3 == 0); // we can pass additional behaviour without any code change

		System.out.println("printing all numbers divisble by 4 in the list");
		filterAndPrint(numList, x -> x % 4 == 0);

		// print square of numbers in the list
		System.out.println("Printing square of numbers in the list");
		/*numList.stream()
			.map(x -> x*x) // parametrize this behaviour
			.forEach(System.out::println);*/

		transformAndPrint(numList, x -> x * x);
		System.out.println("Printing square of numbers + number in the list");
		transformAndPrint(numList, x -> x * x + x);

	}

	private static void transformAndPrint(List<Integer> numList, Function<Integer, Integer> anyFunction) {
		numList.stream()
			.map(anyFunction)
			.forEach(System.out::println);
	}

	private static void filterAndPrint(List<Integer> numList, Predicate<Integer> predicate) {
		numList.stream()
			.filter(predicate)
			.forEach(System.out::println);
	}

}
