package com.java8.udemy.java8plus.Bstreams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Company implements Comparable<Company> {
	private String name;
	private Integer employeeCount;

	@Override
	public int compareTo(Company o) {
		return this.getName().compareTo(o.getName());
	}
}
