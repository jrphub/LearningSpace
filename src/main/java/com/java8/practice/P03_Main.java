package com.java8.practice;

import scala.Tuple2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * How to find duplicate elements in a given integers list in java using Stream functions?
 */
public class P03_Main {
	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> mySet = new HashSet<>();
		myList.stream()
			.filter(n -> !mySet.add(n))
			.forEach(System.out::println);
	}

}
