package com.dsa.BStack;

public class MyStack<T> {
	//attribute
	private Element<T> top;
	private int size = 0;
	private static int MAX_SIZE = 40;


	//push -> size++
	public void push(T data) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException("Stack is full");
		}

		top = new Element<>(data, top);
		size++;
	}

	//pop -> size--
	public T pop() throws StackUnderFlowException {
		if (isEmpty()) {
			throw new StackUnderFlowException("Stack is empty");
		}
		T data = top.getData();
		top = top.getNext();
		size--;
		return data;
	}

	//peek
	public T peek() throws StackUnderFlowException {
		if (isEmpty()) {
			throw new StackUnderFlowException("Stack is empty");
		}
		return top.getData();
	}

	//isEmpty
	public boolean isEmpty() {
		return size == 0;
	}

	//isFull
	public boolean isFull() {
		return size == MAX_SIZE;
	}

	//size
	public int getSize() {
		return size;
	}
}
