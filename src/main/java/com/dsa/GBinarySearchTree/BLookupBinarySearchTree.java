package com.dsa.GBinarySearchTree;

import com.dsa.FTree.TreeNode;

public class BLookupBinarySearchTree {

	public static TreeNode<Integer> lookup(TreeNode<Integer> root, int key) {
		if (root == null) {
			 return null;
		}

		if (root.getData() == key) {
			return root;
		}

		if (key < root.getData()) {
			return lookup(root.getLeftTreeNode(), key);
		} else {
			return lookup(root.getRightTreeNode(), key);
		}
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

		TreeNode<Integer> node = lookup(tNode1, 8);
		System.out.println(node.toString());
	}
}
