package com.java8.udemy.java8plus.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AThePipeline {
	public static void main(String[] args) {
		List<Double> temps = Arrays.asList(98.4, 100.2, 87.9, 102.8);
		System.out.println("No. of temps > 100 is : " +
			temps.stream()
				.peek(System.out::println)
				.filter(temp -> temp > 100)
				.peek(System.out::println)
				.count()
		);
/*
98.4
100.2
100.2
87.9
102.8
102.8
No. of temps > 100 is : 2
 */


	}
}
