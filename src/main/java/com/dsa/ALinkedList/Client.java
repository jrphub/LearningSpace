package com.dsa.ALinkedList;

public class Client {

	public static void main(String[] args) {
		Node<Integer> node = new Node<>(5);
		node.setNext(new Node<>(6));
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.traverse(node);

		//list.addNodeAtEnd(10);
		//list.addNodeAtEnd(11);
		System.out.println(list.countNode());
	}
}
