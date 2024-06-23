package com.java8.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * Write a Java 8 program to sort an array and then convert the sorted array into Stream?
 * https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
 */
public class P09_Main {
	public static void main(String[] args) {
		int[] arr = { 99, 55, 203, 99, 4, 91 };
		Arrays.parallelSort(arr);

		Arrays.stream(arr).forEach(System.out::println);
	}
}
