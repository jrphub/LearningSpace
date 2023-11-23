package com.java8.javabrains;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionsPractice {

	public static void main(String[] args) {
		//create a list of person
		List<Person> personList = Arrays.asList(
				new Person("Sachin", "Tendulkar"),
				new Person("Mahendra Singh", "Dhoni"),
				new Person("Rohit", "Sharma"),
				new Person("Virat", "Kohli"),
				new Person("Rahul", "Dravid")

		);

		//sort list by last column
		personList.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		//personList.sort(Comparator.comparing(Person::getLastName));


		//create a method that prints all elements in the list
		System.out.println("Printing all persons in the list");
		performAction(personList, p -> System.out.println(p),
				p -> true,
				p -> p.getFirstName() + " " + p.getLastName(),
				() -> 2003);


		//create a method that prints all people whose last name starts with "D"
		System.out.println("Printing all persons whose last name starts with D");
		performAction(personList, p -> System.out.println(p),
				p -> p.getLastName().startsWith("D"),
				p -> p.getFirstName().toUpperCase(),
				() -> 2011
				);

	}

	private static void performAction(List<Person> personList,
									  Consumer<Person> consumer,
									  Predicate<Person> predicate,
									  Function<Person, String> function,
									  Supplier<Integer> supplier) {
		for (Person p : personList) {
			if (predicate.test(p)) {
				consumer.accept(p);
				String funcReturned = function.apply(p);
				System.out.println(funcReturned);
				Integer year = supplier.get();
				System.out.println("Best year :" + year );
			}
		}
	}


	private static class Person {
		private String firstName;
		private String lastName;

		public Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		@Override
		public String toString() {
			return "Person{" +
					"firstName='" + firstName + '\'' +
					", lastName='" + lastName + '\'' +
					'}';
		}
	}
}
