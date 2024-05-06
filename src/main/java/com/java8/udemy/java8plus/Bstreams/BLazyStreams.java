package com.java8.udemy.java8plus.Bstreams;

import java.util.stream.Stream;

public class BLazyStreams {
	public static void main(String[] args) {
		Stream.of("Google", "Microsoft", "Amazon", "Meta", "Netflix")
			.peek(System.out::println)
			.filter( s-> {
				System.out.println("filter1 :" + s);
				return s.startsWith("A");
			}).filter(s -> {
				System.out.println("filter2 : " + s);
				return s.length() > 5;
			})
			.limit(1)
			.forEach(System.out::println);

/*
Google
filter1 :Google
Microsoft
filter1 :Microsoft
Amazon
filter1 :Amazon
filter2 : Amazon
Amazon

Observation : Meta and Netflix are not processed due to limit(1)
 */
	}
}
