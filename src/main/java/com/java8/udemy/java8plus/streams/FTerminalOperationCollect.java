package com.java8.udemy.java8plus.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FTerminalOperationCollect {
	public static void main(String[] args) {
		Stream<String> companies1 = Stream.of("microsoft", "google", "amazon");
		StringBuilder strBuilder = companies1.collect(() -> new StringBuilder(),
			(sb, str) -> sb.append(str).append("-"),
			(sb1, sb2) -> sb1.append(sb2));

		System.out.println(strBuilder);//microsoft-google-amazon-

		//ToMap

		//input : "microsoft", "google", "amazon"
		//output : Map<Integer, String> = {6=google,amazon, 9=microsoft}
		Stream<String> companies2 = Stream.of("microsoft", "google", "amazon", "X", "meta");
		Map<Integer, String> mapOutput = companies2.collect(Collectors.toMap(
			k -> k.length(), //key mapper
			v -> v, // value mapper
			(v1, v2) -> v1 + "," + v2) // merge values on duplicate keys
		);
		System.out.println(mapOutput);
		System.out.println(mapOutput.getClass()); // hashmap

		// sort the keys of above output
		Stream<String> companies3 = Stream.of("microsoft", "google", "amazon", "X", "meta");
		TreeMap<Integer, String> companiesTree = companies3.collect(Collectors.toMap(
			k -> k.length(), // key mapper
			v -> v, // value mapper
			(v1, v2) -> v1 + "," + v2, // merge function for duplicate keys
			() -> new TreeMap<>() // Supplier for sorting
		));
		System.out.println(companiesTree);
		System.out.println(companiesTree.getClass()); // treemap

		//input : "microsoft", "google", "amazon", "X", "meta"
		//output : {X=1, amazon=6, google=6, meta=4, microsoft=9}
		Stream<String> companies4 = Stream.of("microsoft", "google", "amazon", "X", "meta");
		TreeMap<String, Integer> companiesOutput = companies4.collect(Collectors.toMap(
			k -> k,
			v -> v.length(),
			(v1, v2) -> v1 + v2,
			() -> new TreeMap<>()
		));
		System.out.println(companiesOutput);

		// groupingBy
		//input : "microsoft", "google", "amazon", "X", "meta"
		//output : {1=[X], 4=[meta], 6=[google, amazon], 9=[microsoft]}
		Stream<String> companies5 = Stream.of("microsoft", "google", "amazon", "X", "X", "meta"); // X is present twice
		Map<Integer, Set<String>> companyOutput = companies5.collect(Collectors.groupingBy(
			s -> s.length(),
			() -> new TreeMap<>(),
			Collectors.toSet()
		));
		System.out.println(companyOutput);
		System.out.println(companyOutput.getClass());

		// partitioningBy - partitioning is a special case of grouping where there are only two possible groups - true and false
		Stream<String> companies6 = Stream.of("microsoft", "google", "amazon", "X", "X", "meta"); // X is present twice
		Map<Boolean, Set<String>> companyOutput6 = companies6.collect(Collectors.partitioningBy(
			s -> s.startsWith("m"),
			Collectors.toSet()
		));
		System.out.println(companyOutput6); // {false=[amazon, X, google], true=[meta, microsoft]}


	}
}
