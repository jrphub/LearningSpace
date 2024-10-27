package com.java8.sortingObjects;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * By implementing Comparable, we set natural ordering of objects
 */
@Data
@AllArgsConstructor
public class Student implements Comparable<Student>{
	private String name;
	private int rollNo;
	private int marks;
	private double feesPaid;


	@Override
	public int compareTo(Student s) {
		return this.rollNo - s.rollNo;
	}

	@Override
	public String toString() {
		return name + " , " + rollNo + " , " + marks + " , " + feesPaid + "\n" ;
	}
}


