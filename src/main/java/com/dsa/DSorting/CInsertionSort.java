package com.dsa.DSorting;

public class CInsertionSort {
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

	public static void insertionSort(int[] arrToSort) {
		for (int i = 0; i < arrToSort.length - 1; i++) { // go up to 2nd last element
			for (int j = i + 1; j > 0; j--) { // consider till ith element is sorted
				if (arrToSort[j] < arrToSort[j - 1]) {
					swap(arrToSort, j, j - 1);
				} else { // if no swap is, performed
					break;
				}
				System.out.println("\n");
				print(arrToSort);
			}
		}
	}

	public static void main(String[] args) {
		insertionSort(new int[]{4, 2, 5, 6, 1, 7});
	}
}
