package com.dsa.GBinarySearchTree;

import com.dsa.FTree.TreeNode;
import scala.reflect.Tree;

public class EMirrorBST {

	public static void mirror(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}

		mirror(root.getLeftTreeNode());
		mirror(root.getRightTreeNode());

		//swap left and right tree node
		TreeNode<Integer> temp = root.getLeftTreeNode();
		root.setLeftTreeNode(root.getRightTreeNode());
		root.setRightTreeNode(temp);


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

		mirror(tNode1);
		//traverse tree
	}
}
