package com.java8.udemy.java8plus.streams;

import java.util.stream.Stream;

public class CCreateStreams {
	public static void main(String[] args) {
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
