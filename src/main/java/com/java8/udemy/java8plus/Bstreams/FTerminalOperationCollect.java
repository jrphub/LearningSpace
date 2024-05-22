package com.java8.udemy.java8plus.Bstreams;

import scala.Tuple2;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Important
 *
 * Revise
 */
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

		Company google = new Company("google", 100);
		Company microsoft = new Company("microsoft", 500);
		Company x = new Company("X", 200);
		Company meta = new Company("Meta", 300);
		Tuple2<String, Company> t1 = new Tuple2("A", google);
		Tuple2<String, Company> t2 = new Tuple2("B", microsoft);
		Tuple2<String, Company> t3 = new Tuple2("A", x);
		Tuple2<String, Company> t4 = new Tuple2("B", meta);

		Stream<Tuple2<String, Company>> tuple2Stream = Stream.of(t1, t2, t3, t4);
		//A, [google, x]
		//B, [microsoft]
		//D, [meta]
		/*Map<String, List<Company>> companyMap = tuple2Stream.collect(Collectors.groupingBy(
			Tuple2::_1, Collectors.mapping(Tuple2::_2, Collectors.toList())
		));

		System.out.println(companyMap);*/
		//{A=[Company(name=google, employeeCount=100), Company(name=X, employeeCount=200)], B=[Company(name=microsoft, employeeCount=500), Company(name=Meta, employeeCount=300)]}


		Map<String, SortedSet<Company>> companyMapSorted = tuple2Stream.collect(Collectors.groupingBy(
			Tuple2::_1, Collectors.mapping(Tuple2::_2, Collectors.toCollection(TreeSet::new))
		));

		System.out.println(companyMapSorted);
		//{A=[Company(name=X, employeeCount=200), Company(name=google, employeeCount=100)], B=[Company(name=Meta, employeeCount=300), Company(name=microsoft, employeeCount=500)]}

		companyMapSorted.entrySet().parallelStream().forEachOrdered( c-> {
			System.out.println(c.getKey());
			System.out.println(c.getValue());
		});

		List<String> list = Arrays.asList("A", "B", "C", "D");
		Map<String, List<String>> map = list.stream()
			.collect(Collectors.toMap(Function.identity(), Arrays::asList));
		System.out.println(map); // {A=[A], B=[B], C=[C], D=[D]} // but doesn't work with duplicate key

		//for duplicate keys
		Function<Map.Entry<String, List<String>>, String> key = (entry) -> {
			return entry.getKey();
		};
		Function<Map.Entry<String, List<String>>, List<String>> value = (entry) -> {
			return new ArrayList<String>(entry.getValue());
		};
		BinaryOperator<List<String>> merge = (old, latest)->{
			old.addAll(latest);
			return old;
		};

		Map<String, List<String>> map1 = new HashMap<>();
		map1.put("A", Arrays.asList("A1", "A2"));
		map1.put("B", Arrays.asList("B1"));
		map1.put("D", Arrays.asList("D1"));

		Map<String, List<String>> map2 = new HashMap<>();
		map2.put("C", Arrays.asList("C1","C2"));
		map2.put("D", Arrays.asList("D2"));

		Stream<Map<String, List<String>>> stream =Stream.of(map1, map2);
		System.out.println(stream.flatMap((mapx)->{
			return mapx.entrySet().stream();
		}).collect(Collectors.toMap(key, value, merge)));


		// sort by companies name length
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
