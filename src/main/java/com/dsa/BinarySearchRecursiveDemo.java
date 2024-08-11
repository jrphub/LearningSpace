package com.dsa;

public class BinarySearchRecursiveDemo {
	public static void main(String[] args) {
		int[] arr = new int[]{3, 6, 8, 12, 14, 17, 25, 29, 31, 36, 42, 47, 53, 55, 62}; //Array has to be sorted
		int indexOfKey = getIndexOfKeyUsingBinarySearch(arr, 1, arr.length, 55);
		if (indexOfKey == 0) {
			System.out.println("key not found in array");
		} else {
			System.out.println("Key is present at index : " + indexOfKey);
		}
	}

	private static int getIndexOfKeyUsingBinarySearch(int[] arr, int l, int h, int key) {

		if (l == h) {
			if (key == arr[l]) {
				return l;
			} else {
				return 0; // key not found
			}
		} else {
			int mid = (l + h) / 2;
			if (key == arr[mid]) {
				return mid;
			}

			if (key < arr[mid]) {
				return getIndexOfKeyUsingBinarySearch(arr, l, mid - 1, key);
			} else {
				return getIndexOfKeyUsingBinarySearch(arr, mid + 1, h, key);
			}
		}
	}


}
