package com.java8.sortingObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStudents {

	public static void main(String[] args) {
		List<Student> students = createStudents();
		System.out.println("Before Sorting");
		System.out.println(students);
		//[Virat , 1 , 85 , 900.0
		//, Sachin , 2 , 75 , 800.0
		//, Dhoni , 3 , 65 , 900.0
		//]


		//This will sort by natural ordering defined by Student Class
		//As Student class implements Comparable, it will sort defined by compareTo()
		Collections.sort(students);
		System.out.println("After Sorting by Natural ordering");
		System.out.println(students);
		//[Virat , 1 , 85 , 900.0
		//, Sachin , 2 , 75 , 800.0
		//, Dhoni , 3 , 65 , 900.0
		//]

		//Now we want to sort students by their marks
		//This not natural ordering
		//We can use Comparator to satisfy this dynamic requirement
		//Collections.sort(students, (s1, s2) -> s1.getMarks() - s2.getMarks()); //ascending
		//Collections.sort(students, (s1, s2) -> s2.getMarks() - s1.getMarks()); // descending
		Collections.sort(students, Comparator.comparingInt(Student::getMarks)); // ascending
		//Comparator returns int [1, 0, -1]
		System.out.println("After sorting by marks");
		System.out.println(students);
		//[Dhoni , 3 , 65 , 900.0
		//, Sachin , 2 , 75 , 800.0
		//, Virat , 1 , 85 , 900.0
		//]

		//Now we want to sort students by their name as well
		//As this is different from Natural Ordering, we will use Comparator
		//Collections.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName())); // lexicographically ascending
		//Collections.sort(students, (s1, s2) -> s2.getName().compareTo(s1.getName())); // lexicographically descending
		Collections.sort(students, Comparator.comparing(Student::getName)); // lexicographically ascending
		System.out.println("After sorting by name");
		System.out.println(students);
		//[Dhoni , 3 , 65 , 900.0
		//, Sachin , 2 , 75 , 800.0
		//, Virat , 1 , 85 , 900.0
		//]

		//Now we want sort students by their fees paid
		//Collections.sort(students, (s1, s2) -> (int) (s1.getFeesPaid() - s2.getFeesPaid())); // ascending
		// we need to cast to int as Comparator returns int
		//Collections.sort(students, Comparator.comparing(Student::getFeesPaid)); // no casting needed
		//Collections.sort(students, Comparator.comparingDouble(Student::getFeesPaid)); // no casting needed
		Collections.sort(students, Comparator.comparingDouble(Student::getFeesPaid).reversed()); //reverse order
		System.out.println("After sorting by fees paid");
		System.out.println(students);
		//[Dhoni , 3 , 65 , 900.0
		//, Virat , 1 , 85 , 900.0
		//, Sachin , 2 , 75 , 800.0
		//]


		//Suppose, school decided, first we will sort students by their fees paid (highest first), and then by marks (highest first)
		Collections.sort(students, Comparator.comparingDouble(Student::getFeesPaid).reversed()
			.thenComparing(Student::getMarks).reversed()); // gave wrong result
		System.out.println("After sorting by fees paid and marks");
		System.out.println(students);
		//[Sachin , 2 , 75 , 800.0
		//, Virat , 1 , 85 , 900.0
		//, Dhoni , 3 , 65 , 900.0
		//]


		//let's correct it by using CustomComparator
		Collections.sort(students, new CustomComparator());
		System.out.println("After sorting by fees paid and marks");
		System.out.println(students);
		//[Virat , 1 , 85 , 900.0
		//, Sachin , 2 , 75 , 800.0
		//, Dhoni , 3 , 65 , 900.0
		//]

	}

	private static List<Student> createStudents() {
		List<Student> students = new ArrayList<>(); // modifiable list
		Student s1 = new Student("Virat", 1, 85, 900d);
		Student s2 = new Student("Sachin", 2, 75, 800d);
		Student s3 = new Student("Dhoni", 3, 65, 900d);
		students.add(s1);
		students.add(s2);
		students.add(s3);
		return students;
		//List.of(s1, s2, s3) returns Unmodifiable list,
		// which will throw exception while sorting as it involve swap of elements
	}
}
