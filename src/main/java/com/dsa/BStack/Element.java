package com.dsa.BStack;

public class Element<T> {
	T data;
	Element<T> next;

	public Element(T data, Element<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Element<T> getNext() {
		return next;
	}

	public void setNext(Element<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Element{" +
			"data=" + data +
			'}';
	}
}
