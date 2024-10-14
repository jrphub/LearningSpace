package com.dsa.FTree;

public class TreeNode<T> {
	T data;
	TreeNode<T> leftTreeNode;
	TreeNode<T> rightTreeNode;

	public TreeNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public TreeNode<T> getLeftTreeNode() {
		return leftTreeNode;
	}

	public TreeNode<T> getRightTreeNode() {
		return rightTreeNode;
	}

	public void setLeftTreeNode(TreeNode<T> leftTreeNode) {
		this.leftTreeNode = leftTreeNode;
	}

	public void setRightTreeNode(TreeNode<T> rightTreeNode) {
		this.rightTreeNode = rightTreeNode;
	}

	@Override
	public String toString() {
		return "TreeNode{" +
			"data=" + data +
			'}';
	}

}
