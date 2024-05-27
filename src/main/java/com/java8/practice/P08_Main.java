package com.java8.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * How will you get the current date and time using Java 8 Date and Time API?
 * https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
 */
public class P08_Main {
	public static void main(String[] args) {
		System.out.println("Current local date : " + LocalDate.now());
		System.out.println("Current local time : " + LocalTime.now());
		System.out.println("Current local date and  time : " + LocalDateTime.now());
	}
}
