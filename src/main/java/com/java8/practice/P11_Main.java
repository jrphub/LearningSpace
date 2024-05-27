package com.java8.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * How to find only duplicate elements with its count from the String ArrayList in Java8?
 * https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
 */
public class P11_Main {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		Map<String, Long> namesCount = names
			.stream()
			.peek(System.out::println)
			.filter(x -> Collections.frequency(names, x) > 1)
			.peek(System.out::println)
			.collect(Collectors.groupingBy
				(Function.identity(), Collectors.counting()));
		System.out.println(namesCount);

	}

	@Data
	@AllArgsConstructor
	static class Notes {
		int id;
		String desc;
		int tagId;
	}
}
