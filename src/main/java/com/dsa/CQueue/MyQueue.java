package com.dsa.CQueue;

import com.dsa.BStack.StackOverflowException;
import com.dsa.BStack.StackUnderFlowException;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyQueue<T> {

	private T[] elements;
	private static final int MAX_SIZE = 40;
	private static final int SPL_EMPTY_VAL = -1;

	// The head index is initialized to empty value
	// denoting to empty queue
	private int headIndex = SPL_EMPTY_VAL;
	private int tailIndex = SPL_EMPTY_VAL;

	public MyQueue(Class<T> tClass) {
		elements = (T[]) Array.newInstance(tClass, MAX_SIZE);
		// This is how generic array is initialized in Java
	}

	//isEmpty?
	public boolean isEmpty() {
		return headIndex == SPL_EMPTY_VAL;
	}

	//is full ?
	public boolean isFull() {
		int nextIndex = (tailIndex + 1) % elements.length;
		return nextIndex == headIndex;
	}

	// enqueue
	public void enqueue(T data) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException("Queue is full");
		}

		//get the next tail index and insert the value there
		tailIndex = (tailIndex + 1) % elements.length;
		elements[tailIndex] = data;

		//for first element
		if (headIndex == SPL_EMPTY_VAL) {
			headIndex = tailIndex;
		}
	}

	//dequeue
	public T dequeue() throws StackUnderFlowException {
		if (isEmpty()) {
			throw new StackUnderFlowException("Queue is empty");
		}

		//head index is pointing to first element
		//store that value to return
		T data = elements[headIndex];

		//if it's the last element in the queue
		if (headIndex == tailIndex) {
			headIndex = SPL_EMPTY_VAL;
		} else {
			headIndex = (headIndex + 1) % elements.length;
		}

		return data;
	}

	@Override
	public String toString() {
		return "MyQueue{" +
			"elements=" + Arrays.toString(elements) +
			'}';
	}

	public static void main(String[] args) throws StackOverflowException, StackUnderFlowException {
		MyQueue<Integer> queue = new MyQueue<>(Integer.class);
		queue.enqueue(5);
		queue.enqueue(10);
		queue.enqueue(2);
		queue.enqueue(4);
		System.out.println(queue);

		Integer element1 = queue.dequeue();
		System.out.println(element1);//5
		Integer element2 = queue.dequeue();
		System.out.println(element2); //10
		Integer element3 = queue.dequeue();
		System.out.println(element3); // 2
		Integer element4 = queue.dequeue();
		System.out.println(element4); // 4
		Integer element5 = queue.dequeue();
		System.out.println(element5); // error

	}

}
