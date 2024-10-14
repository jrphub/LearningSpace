package com.dsa.HHeap;
//Not working
public class HeapSortUsingHeapify {

	//get left child index
	private static int getLeftChildIndex(int root, int endIndex) {
		int leftChildIndex = 2 * root + 1;
		if (leftChildIndex > endIndex) {
			return -1;
		}
		return leftChildIndex;
	}

	//get right child index
	private static int getRightChildIndex(int root, int endIndex) {
		int rightChildIndex = 2 * root + 2;
		if (rightChildIndex > endIndex) {
			return -1;
		}
		return rightChildIndex;
	}

	// get parent index
	private static int getParentIndex(int root, int endIndex) {
		int parentIndex = (root - 1)/2;
		if (parentIndex < 0 || parentIndex > endIndex) {
			return -1;
		}
		return parentIndex;
	}

	private static void percolateDown(int root, int endIndex, int[] arr) {
		int leftChildIndex = getLeftChildIndex(root, endIndex);
		int rightChildIndex = getRightChildIndex(root, endIndex);

		if (leftChildIndex != -1 && arr[leftChildIndex] > arr[root]) {
			swap(leftChildIndex, root);
			percolateDown(root, leftChildIndex, arr);
		}

		if (rightChildIndex != -1 && arr[rightChildIndex] > arr[root]) {
			swap(rightChildIndex, root);
			percolateDown(root, rightChildIndex, arr);
		}
	}

	private static void swap(int index1, int index2) {
		int temp = index1;
		index1 = index2;
		index2 = temp;
	}

	private static void heapify(int endIndex, int[] arr) {
		int parentIndex = getParentIndex(endIndex, endIndex);
		while (parentIndex >= 0) {
			percolateDown(parentIndex, endIndex, arr);
			parentIndex --;
		}
	}

	public static void heapSort(int[] arr) {
		heapify(arr.length - 1, arr);
		int endIndex = arr.length - 1;
		while (endIndex > 0) {
			swap(0, endIndex);
			endIndex --;
			percolateDown(0, endIndex, arr);
		}
		for (int e : arr) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		heapSort(new int[] {5, 2, 6, 8, 2});
	}
}
