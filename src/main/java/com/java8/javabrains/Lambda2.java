package com.java8.javabrains;

public class Lambda2 {

	public static void main(String[] args) {
		printLength(s -> s.length()); //Passing function as value

	}

	public static void printLength(MyLambda2 lambda) {
		final int strLength = lambda.getLength("Hello World");
		System.out.println(strLength);
	}
}

//Functional interface
interface MyLambda2 {
	int getLength(String s);
}
