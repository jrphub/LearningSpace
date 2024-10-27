package com.java8.sortingObjects;

import java.util.Comparator;

public class CustomComparator implements Comparator<Student> {


	@Override
	public int compare(Student s1, Student s2) {
		if (s2.getFeesPaid() != s1.getFeesPaid()) {
			return s2.getMarks() - s1.getMarks();
		}
		return 0;
	}
}
