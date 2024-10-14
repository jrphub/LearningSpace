package com.dsa.FTree;

public class DepthFirstPreOrderTraversal {

	public static void preOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		print(root);
		preOrderTraversal(root.getLeftTreeNode());
		preOrderTraversal(root.getRightTreeNode());
	}

	private static void print(TreeNode node) {
		System.out.println(node.toString());
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

		preOrderTraversal(tNode1); // 5 , 6, 2, 3, 8
	}
}
