package com.dsa.GBinarySearchTree;

import com.dsa.FTree.TreeNode;

public class DMaximumDepthBST {

	public static int maxDepth(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}

		if (root.getLeftTreeNode() == null && root.getRightTreeNode() == null) {
			return 0;
		}

		int leftMaxDepth = 1 + maxDepth(root.getLeftTreeNode());
		int rightMaxDepth = 1 + maxDepth(root.getRightTreeNode());

		return Math.max(leftMaxDepth, rightMaxDepth);
	}

	public static void main(String[] args) {
		TreeNode tNode1 = new TreeNode(5);
		TreeNode tNode2 = new TreeNode(6);
		TreeNode tNode3 = new TreeNode(8);
		TreeNode tNode4 = new TreeNode(2);
		TreeNode tNode5 = new TreeNode(3);

		tNode1.setLeftTreeNode(tNode2);
		tNode1.setRightTreeNode(tNode3);
		tNode2.setLeftTreeNode(tNode4);
		tNode2.setRightTreeNode(tNode5);

		System.out.println("Max Depth :" + maxDepth(tNode1));
	}
}
