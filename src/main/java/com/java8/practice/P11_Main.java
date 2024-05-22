package com.java8.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * How to convert a List of objects into a Map by considering duplicated keys
 * and store them in sorted order?
 * https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
 */
public class P10_Main {
	public static void main(String[] args) {
		List<Notes> noteLst = new ArrayList<>();
		noteLst.add(new Notes(1, "note1", 11));
		noteLst.add(new Notes(2, "note2", 22));
		noteLst.add(new Notes(3, "note3", 33));
		noteLst.add(new Notes(4, "note4", 44));
		noteLst.add(new Notes(5, "note5", 55));

		noteLst.add(new Notes(6, "note4", 66));

		LinkedHashMap<String, Integer> noteMap = noteLst.stream()
			.sorted(Comparator.comparing(Notes::getId).reversed())
			.collect(Collectors.toMap(
				Notes::getDesc,
				Notes::getTagId,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new
			));

		System.out.println(noteMap);

	}

	@Data
	@AllArgsConstructor
	static class Notes {
		int id;
		String desc;
		int tagId;
	}
}
