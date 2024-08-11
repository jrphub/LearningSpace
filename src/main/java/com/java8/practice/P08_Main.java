package com.java8.practice;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
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

		System.out.println("Current timestamp in UTC :" + Instant.now());

		LocalDate firstDate = LocalDate.of(2023, Month.OCTOBER, 22);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM YYYY", Locale.ENGLISH);
		String formatted = formatter.format(firstDate);
		System.out.println("Formatted time :" + formatted);

		/*LocalDate secondDate = LocalDate.parse("22 Oct 2023", formatter);
		System.out.println("day of month: " + secondDate.getDayOfMonth());*/

		// local time
		ZonedDateTime nowLocalTimezone = ZonedDateTime.now();
		System.out.println("Time now [local] : " + nowLocalTimezone);

		//time in New York
		ZonedDateTime nowNewYork = ZonedDateTime.now(TimeZone.getTimeZone("America/New_York").toZoneId());
		System.out.println("Time now [NewYork] : " + nowNewYork);
	}
}
