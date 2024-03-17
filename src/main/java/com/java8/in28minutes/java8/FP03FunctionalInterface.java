package com.java8.in28minutes.java8;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterface {

	public static void main(String[] args) {
		List<Integer> numList = List.of(3, 5, 2, 8, 6);

		//print square of even numbers in the list
		//printSqEvenNum(numList);

		//print sum of elements in the list
		//printSumElements(numList);

		//print random numbers
		//printRandomNumber();

		usageOfDifferentFunctions(numList);
	}

	private static void usageOfDifferentFunctions(List<Integer> numList) {

		UnaryOperator<Integer> unaryOperator = x -> x + x;
		System.out.println("UnaryOperator :" + unaryOperator.apply(5));

		BiPredicate<Integer, String> biPredicate = (x, y) -> {
            return x > 3 && y.length() > 5;
        };

		System.out.println("BiPredicate :" + biPredicate.test(4, "learning Java8"));

		BiFunction<Integer, String, String> biFunction = (x, y) -> {
			return x + " " + y;
		};

		System.out.println(biFunction.apply(1, " - learn"));
		System.out.println(biFunction.apply(2, " - code"));
		System.out.println(biFunction.apply(3, " - rest"));

		BiConsumer<Integer, String> biConsumer = (x, y) -> System.out.println(x + " " + y);
		biConsumer.accept(1, " - learning");
		biConsumer.accept(2, " - coding");
		biConsumer.accept(3, " - take rest");

		IntBinaryOperator intBinaryOperator = (x, y) -> x+ y;
		System.out.println("IntBinaryOperator : " + intBinaryOperator.applyAsInt(5, 8));

	}

	private static void printSqEvenNum(List<Integer> numList) {
		System.out.println("printing a list with square of even numbers :");
		/*numList.stream()
			.filter(x -> x%2 == 0)
			.map(x -> x * x)
			.forEach(System.out::println);*/

		/*Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
		Function<Integer, Integer> squareFunction = x -> x * x;
		Consumer<Integer> printConsumer = System.out::println;

		numList.stream()
			.filter(isEvenPredicate)
			.map(squareFunction)
			.forEach(printConsumer);*/

		Predicate<Integer> isEvenPredicate = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x % 2 == 0;
			}
		};
		Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer x) {
				return x * x;
			}
		};
		Consumer<Integer> printConsumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer x) {
				System.out.println(x);
			}
		};

		numList.stream()
			.filter(isEvenPredicate)
			.map(squareFunction)
			.forEach(printConsumer);
	}

	private static void printSumElements(List<Integer> numList) {

		/*Integer sum = numList.stream().
			reduce(0, Integer::sum);*/ // which kind of Functional Interface is Integer::sum?

		/*BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

		Integer sum = numList.stream().
			reduce(0, sumBinaryOperator);*/

		BinaryOperator<Integer> sumBinaryOperator = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer aggregator, Integer number) {
				return aggregator + number;
			}
		};

		Integer sum = numList.stream().
			reduce(0, sumBinaryOperator);

		System.out.println("Sum : " + sum);

	}

	private static void printRandomNumber() {
		//Supplier
		//Supplier<Integer> randomIntegerSupplier = () -> 2;
		/*Supplier<Integer> randomIntegerSupplier = () -> {
			return 2;
		};*/

		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};

		System.out.println(randomIntegerSupplier.get());
	}
}
