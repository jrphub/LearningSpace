package com.java8.practice;

import scala.Tuple2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Given a String, find the first non-repeated character in it using Stream functions?
 */
public class P05_Main {
	public static void main(String[] args) throws IOException {
		String input = "Java articles are Awesome";
		Character key = IntStream.range(0, input.length()) // java8 version of for loop
			.mapToObj(index -> input.charAt(index))
			.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
			.entrySet()
			.stream()
			//.peek(System.out::println)
			.filter(entry -> entry.getValue() == 1L)
			//.peek(System.out::println)
			.findFirst()
			.get()
			.getKey();

		System.out.println(key);

	}
}
