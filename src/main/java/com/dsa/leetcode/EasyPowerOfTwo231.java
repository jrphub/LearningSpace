package com.dsa.leetcode;

public class EasyPowerOfTwo231 {
	//find out a number is power of 2 or not

	public static void main(String[] args) {
		System.out.println(isNumPowTwo(16));
		System.out.println(isNumPowTwo(15));
		System.out.println(isNumPowTwo(1576327371682391248L));
	}

	private static boolean isNumPowTwo(long num) {//long instead of int
		long i = 1; // long instead of int
		while (i < num) {
			i = i * 2;
		}
		return i == num;
	}
}
