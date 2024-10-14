package com.dsa.GBinarySearchTree;

import com.dsa.FTree.TreeNode;

public class CMinimumValueBST {
	public static TreeNode<Integer> minimumValue(TreeNode<Integer> root) {
		if (root == null) {
			return root;
		}

		if (root.getLeftTreeNode() == null) {
			return root;
		}

		return minimumValue(root.getLeftTreeNode());
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

		TreeNode<Integer> minimumValueNode = minimumValue(tNode1);
		System.out.println(minimumValueNode.toString());
	}
}
