package com.java8.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of integers, sort all the values present in it using Stream functions?
 * https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
 */
public class P06_Main {
	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		myList.stream()
			.sorted(Collections.reverseOrder())
			.forEach(System.out::println);
	}
}
