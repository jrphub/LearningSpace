package com.java8.in28minutes.java8;

import java.util.List;

public class FP02Functional {

	public static void main(String[] args) {
		List<Integer> numList = List.of(2, 3, 7, 12, 54, 73);

		int sum = getSum(numList);
		System.out.println("Sum : " + sum);

		int sumCustom = getSumCustom(numList);
		System.out.println("Sum : " + sumCustom);

		int sumLambda = getSumLambda(numList);
		System.out.println("Sum : " + sumLambda);
	}

	private static int getSumLambda(List<Integer> numList) {
		return numList.stream().reduce(0, (x, y) -> x + y);
	}

	private static int getSum(List<Integer> numList) {
		return numList.stream().reduce(0, Integer::sum);
	}

	private static int getSumCustom(List<Integer> numList) {
		return numList.stream().reduce(0, FP02Functional::sum);
	}

	private static Integer sum(Integer aggregate, Integer nextNumber) {
		System.out.println(aggregate + " " + nextNumber);
		return aggregate + nextNumber;
	}
}
