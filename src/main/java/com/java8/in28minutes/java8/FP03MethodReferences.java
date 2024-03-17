package com.java8.in28minutes.java8;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

	private static void printStr(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		List<String> courses = List.of("java", "spring", "terraform", "aws",
			"kafka", "spark", "spring boot");

		courses.stream()
			//.map( str -> str.toUpperCase())
			.map(String::toUpperCase) // non-static method reference
			//.forEach(System.out::println);
			.forEach(FP03MethodReferences::printStr); // static method reference

		Supplier<String> stringSupplier = String::new; //no-arg constructure
		System.out.println("new string :" + stringSupplier.get());

	}
}
