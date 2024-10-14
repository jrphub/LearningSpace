package com.dsa.ALinkedList;

public class MyLinkedList<T> {

	private Node<T> head;

	public MyLinkedList() {
	}

	public void traverse(Node<T> head) {
		this.head = head;
		while (head != null) {
			System.out.println(head.getData());
			head = head.getNext();
		}
		System.out.println("Traverse completed");
	}

	public void addNodeAtEnd(T data) {
		if (head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> curr = head;
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(new Node<>(data));
		}
	}

	public int countNode() {
		if (head == null) {
			return 0;
		}
		Node<T> curr = head;
		int count = 0;
		while (curr.getNext() != null) {
			curr = curr.getNext();
			count++;
		}
		return count;
	}

	public T popElement() {
		if (head != null) {
			T topElement = head.getData();
			head = head.getNext();
			return topElement;
		}

		return null;
	}
}
