package com.java8.in28minutes.java8;

import java.util.List;

public class FP01Functional {
	public static void main(String[] args) {
		List<Integer> numList = List.of(1, 14, 3, 7, 56, 49, 23);
		printAllNumbers(numList);
		printEvenNumbers(numList);
		printOddNumbers(numList);
		printCubeOfNumbers(numList);
	}

	private static void printAllNumbers(List<Integer> numList) {
		System.out.println("Printing all numbers");
		//numList.stream().forEach(FP01Functional::show); //method reference
		//numList.stream().forEach(x -> show(x)); // Lambda Expression
		numList.stream().forEach(System.out::println); //method reference
	}

	/*private static void show(Integer x) {
		System.out.println(x);
	}*/

	/*private static boolean isEven(int num) {
		return num % 2 == 0;
	}*/

	private static void printEvenNumbers(List<Integer> numList) {
		System.out.println("printing all even numbers");
		numList.stream()
			//.filter(FP01Functional::isEven) //method reference
			.filter( n -> n % 2 == 0)
			.forEach(System.out::println);
	}

	private static void printCubeOfNumbers(List<Integer> numList) {
		System.out.println("printing cube of all numbers");
		numList.stream()
			.map(x -> x * x * x)
			.forEach(System.out::println);
	}

	private static void printOddNumbers(List<Integer> numList) {
		System.out.println("Printing all odd numbers");
		numList.stream()
			.filter(x-> x%2 !=0)
			.forEach(System.out::println);
	}
}
