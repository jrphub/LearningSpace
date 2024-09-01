package com.java8.udemy.java8plus.Bstreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CCreateStreams {
	public static void main(String[] args) throws IOException {
		createStreamFromArray();
		createStreamFromCollection();
		createStreamUsingOf();
		createIntStreamSeries();
		createStreamFromFile();

	}

	private static void createStreamFromFile() throws IOException {
		System.out.println("---createStreamFromFile--");
		Stream<String> lines = Files.lines(Paths.get("src/main/resources/wordcount.txt"));
		lines.forEach(System.out::println);
	}

	private static void createStreamUsingOf() {
		System.out.println("---createStreamUsingOf--");
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
		integerStream.forEach(System.out::println);
	}

	private static void createStreamFromCollection() {
		System.out.println("---createStreamFromCollection--");
		List<Integer> numList = Arrays.asList(1, 3, 4, 5);
		numList.stream().forEach(System.out::println);
	}

	private static void createStreamFromArray() {
		System.out.println("---createStreamFromArray--");
		int[] arr = new int[] {1, 3, 5, 6};
		Arrays.stream(arr).boxed().forEach(System.out::println);
	}

	private static void createIntStreamSeries() {
		System.out.println("---createIntSeries--");
		Stream<Integer> numStreams = Stream.iterate(2,t -> t+2).limit(10);
		numStreams.forEach(System.out::println);
/*
2
4
6
8
10
12
14
16
18
20
 */
	}
}
