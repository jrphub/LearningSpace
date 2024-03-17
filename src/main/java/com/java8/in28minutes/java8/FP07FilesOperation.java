package com.java8.in28minutes.java8;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FP07FilesOperation {
	public static void main(String[] args) throws IOException {
		/*System.out.println("printing all files in root directory of workspace");
		Files.list(Paths.get(".")).forEach(System.out::println);


		System.out.println("printing line in the file");
		Files.lines(Paths.get("src/main/resources/wordcount.txt"))
			.forEach(System.out::println);*/

		Stream<String> wordStream = Files.lines(Paths.get("src/main/resources/wordcount.txt"))
			.map(str -> str.split(" "))
			.flatMap(Arrays::stream)
			.filter(Objects::nonNull);
		//Approach - 1
		Map<String, Integer> frequencyMap = new HashMap<>();
		wordStream.forEach(str -> frequencyMap.merge(str,1, (val, newVal) -> val + newVal));
		System.out.println(frequencyMap);

		Map<String, Long> wordCountMap = wordStream
			//Approach - 2
			//.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			// Approach - 3
			.collect(Collectors.toMap(x -> x, y -> 1L, Long::sum));
		System.out.println(wordCountMap);




		//Find most frequent Item
		String mostFrequentKey = Files.lines(Paths.get("src/main/resources/wordcount.txt"))
			.map(str -> str.split(" "))
			.flatMap(Arrays::stream)
			.filter(Objects::nonNull)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet()
			.stream()
			.max(Comparator.comparing(Map.Entry::getValue))
			.map(Map.Entry::getKey)
			.orElse(null);

		System.out.println("Most frequent item : " + mostFrequentKey);

	}
}
