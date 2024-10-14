package com.dsa.DSorting;

public class ASelectionSort {


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

	// selection sort
	public static void selectionSort(int[] arrToSort) {
		print(arrToSort);
		System.out.println("\n");
		//traverse the array
		for (int i = 0; i < arrToSort.length; i++) {
			//start j , next to i
			for (int j = i + 1; j < arrToSort.length; j++) {
				if (arrToSort[j] < arrToSort[i]) {
					swap(arrToSort, i, j);
					print(arrToSort);
					System.out.println("\n");
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arrToSort = new int[]{5, 10, 2, 4, 7};
		selectionSort(arrToSort); // Complexity : O(n2)
	}
}
