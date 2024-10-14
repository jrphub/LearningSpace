package com.dsa.DSorting;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Complexity = O(nlog n)
// There is n space more needed due to divide phase
public class DMergeSortDemo {

	public static void main(String[] args) {
		int[] arr = new int[]{5, 4, 6, 2, 1, 10, 7, 3, 8, 9};
		mergeSort(arr);
	}

	/**
	 * to divide the input array to two half
	 *
	 * @param arr        input array to be sorted
	 * @param firstHalf  empty first half array with size
	 * @param secondHalf empty seond half array with size
	 */
	private static void split(int[] arr, int[] firstHalf, int[] secondHalf) {
		int k = 0;
		int j = 0;
		int secondHalfStartIndex = firstHalf.length;
		for (int item : arr) {
			if (k < secondHalfStartIndex) {
				firstHalf[k] = arr[k]; // fill the first half array
			} else {
				secondHalf[j++] = arr[k]; // fill the second half array
			}
			k++;
		}
	}

	/**
	 * To create merge array
	 *
	 * @param arr        input array to be sorted
	 * @param firstHalf  first half of array with size
	 * @param secondHalf second half of array with size
	 */
	private static void merge(int[] arr, int[] firstHalf, int[] secondHalf) {
		int i = 0; // for first half array index
		int j = 0; // for second half array index
		int k = 0; // for merge array index

		int m = firstHalf.length;
		int n = secondHalf.length;

		while (i < m && j < n) {
			if (firstHalf[i] < secondHalf[j]) {
				arr[k] = firstHalf[i]; //smaller value should go to the merge array
				i++;
			} else if (secondHalf[j] < firstHalf[i]) {
				arr[k] = secondHalf[j]; //smaller value should go to the merge array
				j++;
			}
			k++;
		}

		//if one list is larger than other,
		//then copy the rest elements to merge array

		if (i < m) {
			while (k < arr.length) {
				arr[k++] = firstHalf[i++];
			}
		}

		if (j < n) {
			while (k < arr.length) {
				arr[k++] = secondHalf[j++];
			}
		}
	}

	private static void mergeSort(int[] arr) {
		if (arr.length == 1) {
			return; //do nothing
		}
		int midIndex = (arr.length / 2) + (arr.length % 2);
		int[] firstHalf = new int[midIndex]; //empty first half array with size
		int[] secondHalf = new int[arr.length - midIndex]; // empty second half array with size

		split(arr, firstHalf, secondHalf);

		mergeSort(firstHalf);
		mergeSort(secondHalf);

		merge(arr, firstHalf, secondHalf);

		printArr(arr);
	}

	private static void printArr(int[] arr) {
		List<Integer> intList = IntStream.of(arr).boxed().collect(Collectors.toList());
		System.out.println(intList);
	}
}
