package com.java8.in28minutes.java8;

import java.util.List;
import java.util.stream.Collectors;

public class FP06StreamsJoining {
	public static void main(String[] args) {
		List<String> courses = List.of("java", "spring", "terraform", "aws",
			"kafka", "spark", "spring boot");

		System.out.println(courses.stream().collect(Collectors.joining("-")));
	}
}
