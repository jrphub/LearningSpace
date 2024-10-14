package com.dsa.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class EasyDuplicateElements217 {
	// return true if the array contains duplicate elements

	public static void main(String[] args) {
		int[] num = new int[]{1, 2, 4, 1};
		System.out.println(checkDuplicateInArr(num));
	}

	private static boolean checkDuplicateInArr(int[] num) {

		//bruteforce approach
		//take 2 pointers
		//O(n2)
		/*for (int i=0; i< num.length; i++) {
			for (int j=i+1; j < num.length; j++) {
				if(num[i] == num[j]) {
					return true;
				}
			}
		}
		return false;*/

		//approach - 2 : sorting
		/*Arrays.sort(num);
		for (int i = 0; i < num.length - 1; i++) {
			// loop till 2nd last element, else it will
			// throw array index out of bound exception
			if (num[i] == num[i + 1]) {
				return true;
			}
		}
		return false;*/

		//approach - 3 : Using HashSet
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i=0; i< num.length; i++) {
			if (hashSet.contains(i)) {
				return true;
			}
			hashSet.add(num[i]);
		}
		return false;


	}

}
