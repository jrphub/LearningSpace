package com.dsaPattern.TwoPointers;

public class AValidPalindrom {
	public static void main(String[] args) {
		String str = "racecar";
		System.out.println(isValidPalindrom(str));
	}

	static boolean isValidPalindrom(String s) {
		char[] charArray = s.toCharArray();
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (charArray[left] != charArray[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
