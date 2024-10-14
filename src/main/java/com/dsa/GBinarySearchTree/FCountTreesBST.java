package com.dsa.GBinarySearchTree;

public class FCountTreesBST {
	public static int countTree(int numOfNodes) {
		//base case
		if (numOfNodes <= 1) {
			return 1;
		}

		int sum = 0;
		//consider that every node can be the root node
		// i.e. the node before it, will be left node
		// and the node after it, will be the right node

		// nodes on the left and right form their own sub tree
		for (int i = 1; i <= numOfNodes; i++) {
			int countLeftTrees = countTree(i - 1);
			int countRightTress = countTree(numOfNodes - i);
			sum = sum + (countLeftTrees * countRightTress);
			// This is the no. of possible trees with this root
			// the combination of left and right sub tree
		}

		return sum;
	}
}
