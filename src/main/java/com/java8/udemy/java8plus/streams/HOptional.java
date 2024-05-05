package com.java8.udemy.java8plus.streams;

import java.util.Arrays;
import java.util.Optional;

public class HOptional {
	public static void main(String[] args) {
		Optional<Double> optAvg = calcAverage(50, 60, 70);

		if (optAvg.isPresent()) {
			System.out.println(optAvg.get());//60.0
		}

		optAvg.ifPresent(System.out::println); //60.0

		System.out.println(optAvg.orElse(Double.NaN)); // 60.0

		Optional<Double> optAvg2 = calcAverage(); // will return an empty Optional
		System.out.println(optAvg2.orElse(Double.NaN)); // NaN
		System.out.println(optAvg2.orElseGet(() -> Math.random())); //0.07355701827134065



	}

	public static Optional<Double> calcAverage(int... scores) {
		if (scores.length == 0) return Optional.empty();

		double sum = Arrays.stream(scores).sum();
		return Optional.of(sum/scores.length);
	}
}
