package com.java8.practice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an integer array nums,
 * return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 * https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
 */
public class P07_Main {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1};
		List<Integer> myList = Arrays.stream(nums)
			.boxed()
			.collect(Collectors.toList());
		Set<Integer> mySet = new HashSet<>(myList);
		if (myList.size() > mySet.size()) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
}
