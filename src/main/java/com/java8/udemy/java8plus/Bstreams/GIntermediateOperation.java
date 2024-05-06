package com.java8.udemy.java8plus.Bstreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class GIntermediateOperation {
	public static void main(String[] args) {
		Stream<String> companies3 = Stream.of("microsoft", "google", "amazon", "X", "X", "meta");
		//distinct
		companies3.peek(s -> System.out.println("1 : " + s))
			.distinct() // a stateful intermediate operation
			.forEach(s -> System.out.println("2 : " + s));
		/**
		 * 1 : microsoft
		 * 2 : microsoft
		 * 1 : google
		 * 2 : google
		 * 1 : amazon
		 * 2 : amazon
		 * 1 : X
		 * 2 : X
		 * 1 : X
		 * 1 : meta
		 * 2 : meta
		 */

		// map - 1:1 mapping
		Stream<String> companies4 = Stream.of("microsoft", "google", "amazon", "X", "X", "meta");
		companies4.map(s -> s.length())
			.forEach(System.out::print); // 966114

		// flatmap
		List<String> list1 = Arrays.asList("google", "microsoft");
		List<String> list2 = Arrays.asList("meta", "X");
		Stream<List<String>> listStream = Stream.of(list1, list2);
		Stream<String> stringStream = listStream.flatMap(list -> list.stream());//Stream<List<String>> -> Stream<String>
		stringStream.forEach(System.out::println);
		/**
		 * google
		 * microsoft
		 * meta
		 * X
		 */

		//sorted
		Company company1 = new Company("Meta", 100);
		Company company2 = new Company("Google", 120);
		Stream.of(company1, company2)
			.sorted(Comparator.comparing( company -> company.getEmployeeCount()))
			.forEach(System.out::println);
		/**
		 * Company(name=Meta, employeeCount=100)
		 * Company(name=Google, employeeCount=120)
		 */



	}
}
