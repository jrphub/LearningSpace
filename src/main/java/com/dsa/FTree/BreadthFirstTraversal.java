package com.dsa.FTree;

import com.dsa.BStack.StackOverflowException;
import com.dsa.BStack.StackUnderFlowException;
import com.dsa.CQueue.MyQueue;
import scala.reflect.Tree;

public class BreadthFirstTraversal {

	public static void breadthFirst(TreeNode root) throws StackOverflowException, StackUnderFlowException {
		//base case
		if (root == null) {
			return;
		}
		MyQueue<TreeNode> queue = new MyQueue<>(TreeNode.class);
		queue.enqueue(root);
		// root -> left -> right
		while (!queue.isEmpty()) { //iterative approach
			TreeNode node = queue.dequeue();
			print(node);

			if (node.getLeftTreeNode() != null) {
				queue.enqueue(node.getLeftTreeNode());
			}

			if (node.getRightTreeNode() != null) {
				queue.enqueue(node.getRightTreeNode());
			}
		}
	}

	private static void print(TreeNode node) {
		System.out.println(node.getData());
	}

	public static void main(String[] args) throws StackUnderFlowException, StackOverflowException {
		TreeNode tNode1 = new TreeNode(5);
		TreeNode tNode2 = new TreeNode(6);
		TreeNode tNode3 = new TreeNode(8);
		TreeNode tNode4 = new TreeNode(2);
		TreeNode tNode5 = new TreeNode(3);

		tNode1.setLeftTreeNode(tNode2);
		tNode1.setRightTreeNode(tNode3);
		tNode2.setLeftTreeNode(tNode4);
		tNode2.setRightTreeNode(tNode5);

		breadthFirst(tNode1); // 5 6 8 2 3
	}
}
