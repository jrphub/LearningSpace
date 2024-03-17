package com.java8.in28minutes.java8;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Exercise {
	public static void main(String[] args) {
		List<Integer> numList = List.of(3, 6, 2, 9, 4);

		printMin(numList);
		printMax(numList);
		//square every number and find sum of squares
		printSumSquares(numList);
		//sum of Odd numbers in the list
		printSumOdd(numList);

		//create another list with square of number
		printAnotherListSqrNum(numList);
	}

	private static void printAnotherListSqrNum(List<Integer> numList) {
		System.out.println("A new list with sq. of numbers");
		List<Integer> numList2 = numList.stream().map(x -> x * x).collect(Collectors.toList());
		numList2.forEach(System.out::println);
	}

	private static void printSumOdd(List<Integer> numList) {
		Integer sumOdd = numList.stream().filter(x -> x % 2 != 0).reduce(0, Integer::sum);
		System.out.println("Sum of odd numbers : " + sumOdd);
	}

	private static void printSumSquares(List<Integer> numList) {
		Integer sumOfSquares = numList.stream()
			.map(x -> x * x)
			.reduce(0, Integer::sum);
		System.out.println("Sum of squares : "  + sumOfSquares );
	}

	private static void printMax(List<Integer> numList) {
		System.out.println("Printing max element in the list :");
		Integer max = numList.stream().reduce(Integer.MIN_VALUE, Integer::max);
		System.out.println(max);
	}

	private static void printMin(List<Integer> numList) {
		System.out.println("Printing minimum number in the list :");
		//Integer min = numList.stream().reduce(0, (x, y) -> x < y ? x : y); // 0
		//Integer min = numList.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y); // 2
		Integer min = numList.stream().reduce(Integer.MAX_VALUE, Integer::min);
		System.out.println(min);
	}
}
