package com.dsa;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Complexity : O(nlog n)
//Worst case : O(n2) // when the array is already sorted
public class QuickSortDemo {

	public static void main(String[] args) {
		int[] arr = new int[]{10, 16, 8, 12, 15, 6, 3, 9, 5};
		quickSort(arr, 0, 8);

	}

	//partition
	//Objective : Put pivot element at correct position in the array, so that
	//all elements present at left of pivot is smaller than pivot
	//and all elements present at right of pivot is larger than pivot

	/**
	 * @param arr  input array to be sorted
	 * @param low  first element of array to be sorted
	 * @param high last element of array to be sorted
	 * @return pivot index
	 */
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		System.out.println("Pivot : " + pivot);
		int l = low;
		int h = high;

		while (l < h) {
			while (arr[l] <= pivot && l < h) { //l will search for element > pivot
				l++;
			} // when found, stop
			while (arr[h] > pivot) { //h will search for element < pivot
				h--;
			} //when found, stop
			if (l < h) {
				swap(arr, l, h); //array is mutable
			} // elements at l & h are swapped
		} // when l > h, stop
		swap(arr, low, h); // get the new pivot at start of array
		printArr(arr);
		return h; // return pivot index
	}

	//quickSort - Divide and Conquer
	private static void quickSort(int[] arr, int low, int high) {
		if (low > high) {
			return; //do nothing
		} else {
			int pivotIndex = partition(arr, low, high); // get the pivot index
			quickSort(arr, low, pivotIndex - 1); // sort the left part of pivot
			quickSort(arr, pivotIndex + 1, high); // sort the right part of pivot
		}

	}

	private static void printArr(int[] arr) {
		List<Integer> intList = IntStream.of(arr).boxed().collect(Collectors.toList());
		System.out.println(intList);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
