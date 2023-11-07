package com.java8.javabrains;

public class Lambda1 {

	public static void main(String[] args) {
		MyLambda myLambda = s -> s.length();
		final int strLength = myLambda.getLength("Hello World");
		System.out.println(strLength);
	}
}

interface MyLambda {
	int getLength(String s);
}
