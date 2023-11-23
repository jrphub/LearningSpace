package com.java8.javabrains;

public class Calculator {

	public void getResult(MyCalculator calculateFunc, int a, int b) {
		final int result = calculateFunc.calculate(a, b);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();

		//lambda way presentation
		MyCalculator addition = (a, b) -> a + b;

		//alternate way presentation
		MyCalculator multiplication = new MyCalculator() {
			@Override
			public int calculate(int a, int b) {
				return a * b;
			}
		};

		MyCalculator subtraction = (a, b) -> a - b;

		MyCalculator division = (a, b) -> {
			if (b == 0) {
				return -1;
			} else {
				return a / b;
			}
		};


		calculator.getResult(addition, 5, 6);
		calculator.getResult(multiplication, 5, 6);
		calculator.getResult(subtraction, 5, 6);
		calculator.getResult(division, 0, 0);
	}
}

interface MyCalculator {
	int calculate(int a, int b);
}
