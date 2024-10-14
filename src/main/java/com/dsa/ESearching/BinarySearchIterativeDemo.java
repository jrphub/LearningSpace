package com.dsa.ESearching;

public class BinarySearchIterativeDemo {
	public static void main(String[] args) {
		int[] arr = new int[]{3, 6, 8, 12, 14, 17, 25, 29, 31, 36, 42, 47, 53, 55, 62}; //Array has to be sorted
		int indexOfKey = getIndexOfKeyUsingBinarySearch(arr, arr.length, 55);
		if (indexOfKey == 0) {
			System.out.println("key not found in array");
		} else {
			System.out.println("Key is present at index : " + indexOfKey);
		}
	}

	private static int getIndexOfKeyUsingBinarySearch(int[] arr, int arrLength, int key) {

		int l = 1;
		int h = arrLength;
		System.out.println("Traversal of indices...");
		while (l <= h) {
			int mid = (l + h) / 2;

			if (key == arr[mid]) {
				return mid;
			}
			if (key < arr[mid]) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
			System.out.println("[" + l + "," + mid + "," + h + "]");
		}
		return 0;
	}


}
