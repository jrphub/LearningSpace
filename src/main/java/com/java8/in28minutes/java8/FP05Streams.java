package com.java8.in28minutes.java8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FP05Streams {

	public static void main(String[] args) {
		Stream<Integer> integerStream = Stream.of(3, 6, 2, 8, 4, 5);

		System.out.println(integerStream.reduce(Integer::sum).get()); //28

		int[] arr = {3, 6, 2, 8, 4, 5};
		System.out.println(Arrays.stream(arr).sum()); // 28

		System.out.println(IntStream.range(1, 10).sum()); //45
		System.out.println(IntStream.rangeClosed(1, 10).sum()); // 55
		System.out.println(IntStream.iterate(1, x -> x+2).limit(10).sum()); // 100
		System.out.println(IntStream.iterate(0, x -> x+2).limit(10).sum());//90
		System.out.println(IntStream.iterate(2, x -> x+2).limit(10).peek(System.out::println).sum());
	}
}
