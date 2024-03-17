package com.java8.in28minutes.java8;

import java.util.Comparator;
import java.util.List;

public class FP01Exercise {

	public static void main(String[] args) {
		List<String> courses = List.of("java", "spring", "terraform", "aws",
			"kafka", "spark", "spring boot");

		printCourseWithWordSpring(courses);
		printCourseWithAtleastNLetter(courses, 4);
		printCourseLength(courses);

		//sort
		sortAscending(courses);
		sortDescending(courses);
		sortCustom(courses);
		sortCustomRev(courses);


	}

	private static void sortCustomRev(List<String> courses) {
		System.out.println("Sorting as per length of courses in reverse order");
		courses.stream()
			.sorted(Comparator.comparing( str -> str.length()))
			.sorted(Comparator.reverseOrder())
			.forEach(System.out::println)

		;
	}

	private static void sortCustom(List<String> courses) {
		System.out.println("printing as per length of the courses");
		courses.stream()
			.sorted(Comparator.comparing( str -> str.length()))
			.forEach(System.out::println);
	}

	private static void sortDescending(List<String> courses) {
		System.out.println("Printing courses in descending natural order");
		courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

	private static void sortAscending(List<String> courses) {
		System.out.println("Printing courses with Natural order");
		courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println); // a ..z
	}

	private static void printCourseWithWordSpring(List<String> courses) {
		System.out.println("Print course with word spring");
		courses.stream().filter(x -> x.contains("spring")).forEach(System.out::println);
	}

	private static void printCourseWithAtleastNLetter(List<String> courses, int letterCount) {
		System.out.println("Courses with at least " + letterCount + " letters");
		courses.stream().filter( x -> x.toCharArray().length > letterCount).forEach(System.out::println);
	}

	private static void printCourseLength(List<String> courses) {
		System.out.println("Printing length of each course");
		courses.stream().map( x -> x.toCharArray().length).forEach(System.out::println);
	}
}
