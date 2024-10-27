package com.dsaPattern.TwoPointers;

import java.util.Arrays;

public class BSumOfThree {

	public static void main(String[] args) {
		/*int[] nums = new int[]{3, 7, 1, 2, 8, 4, 5};
		int target = 10;*/
		/*int[] nums = new int[]{1, -1, 0};
		int target = -1;*/
		int[] nums = new int[]{-1, 2, 1, -4, 5, -3};
		int target = -8;

		System.out.println(findSumOfThree(nums, target));
	}

	private static boolean findSumOfThree(int[] nums, int target) {

		Arrays.sort(nums);
		int low, high, triples;

		for (int i = 0; i < nums.length - 2; i++) {
			low = i + 1;
			high = nums.length - 1;

			while (low < high) {
				triples = nums[i] + nums[low] + nums[high];

				if (triples == target) {
					return true;
				}
				else if (triples < target) {
					low++;
				}
				else {
					high--;
				}
			}
		}
		return false;
	}
}
