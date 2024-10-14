package com.dsa.GBinarySearchTree;

import com.dsa.FTree.TreeNode;

public class AInsertionBinarySearchTree {
	public static TreeNode<Integer> insert(TreeNode<Integer> root, TreeNode<Integer> newNode) {
		if (root == null) {
			return newNode;
		}

		if (newNode.getData() <= root.getData()) {
			print(root);
			root.setLeftTreeNode(insert(root.getLeftTreeNode(), newNode));
		} else {
			print(root);
			root.setRightTreeNode(insert(root.getRightTreeNode(), newNode));
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode tNode1 = new TreeNode(5);
		TreeNode tNode2 = new TreeNode(6);
		TreeNode tNode3 = new TreeNode(8);
		TreeNode tNode4 = new TreeNode(2);
		TreeNode tNode5 = new TreeNode(3);

		TreeNode tNodeNew = new TreeNode(4);

		tNode1.setLeftTreeNode(tNode2);
		tNode1.setRightTreeNode(tNode3);
		tNode2.setLeftTreeNode(tNode4);
		tNode2.setRightTreeNode(tNode5);

		insert(tNode1, tNodeNew);

	}

	private static void print(TreeNode node) {
		System.out.println(node.getData());
	}
}
