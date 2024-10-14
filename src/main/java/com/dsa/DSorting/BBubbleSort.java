package com.dsa.DSorting;

/**
 * 3, 7, 8, 1, 2
 */
public class BBubbleSort {

	// helper methods
	//print all elements in a list
	public static void print(int[] arrToSort) {
		for (int elm : arrToSort) {
			System.out.print(elm + ",");
		}
	}

	// swap elements in the list
	public static void swap(int[] arrToSort, int index1, int index2) {
		int temp = arrToSort[index1];
		arrToSort[index1] = arrToSort[index2];
		arrToSort[index2] = temp;
	}

	/*public static void bubbleSort(int[] arrToSort) {
		for (int i = 0; i < arrToSort.length; i++) {
			boolean swapped = false;
			for (int j = arrToSort.length - 1; j > i; j--) {
				if (arrToSort[j] < arrToSort[j-1]) {
					swap(arrToSort, j, j-1);
					print(arrToSort);
					System.out.println("\n");
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}*/

	public static void bubbleSort(int[] arrToSort) {
		for (int i = 0; i < arrToSort.length;) {
			boolean swapped = false;
			for (int j = i + 1; j < arrToSort.length; j++) {
				if (arrToSort[j] < arrToSort[j - 1]) {
					swap(arrToSort, j, j - 1);
					print(arrToSort);
					System.out.println("\n");
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] arrToSort = new int[]{3, 7, 8, 1, 2};
		bubbleSort(arrToSort);
	}
}
