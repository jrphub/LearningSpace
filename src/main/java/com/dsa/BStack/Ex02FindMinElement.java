package com.dsa.BStack;
//Use stack to Find minimum element in constant time
public class Ex02FindMinElement {

	// let's create two stacks
	//one stack to hold all elements
	MyStack<Integer> stack = new MyStack<>();

	//Another stack to hold minimum element
	MyStack<Integer> minStack = new MyStack<>();

	public void push(int data) throws StackUnderFlowException, StackOverflowException {
		//find minimum between element just added
		//and top of minStack
		int min = data;
		if (!minStack.isEmpty()) {
			if (min > minStack.peek()) {
				min = minStack.peek();
			}
		}
		stack.push(data); // push data to stack
		minStack.push(min); // push min element to min Stack
	}

	//pop should pop elements from both the stack
	public int pop() throws StackUnderFlowException {
		minStack.pop();
		return stack.pop();
	}

	//Get minimum is O(1) now
	public int getMinimum() throws StackUnderFlowException {
		return minStack.peek();
	}

	public static void main(String[] args) throws StackUnderFlowException, StackOverflowException {
		Ex02FindMinElement elm = new Ex02FindMinElement();
		elm.push(5);
		elm.push(8);
		elm.push(3);
		elm.push(10);

		System.out.println(elm.getMinimum());
	}

}
