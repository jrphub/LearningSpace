package com.dsa.BStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ex01MatchingParanthesis {
	public static final Map<Character, Character> matchingParantheisMap = new HashMap<>();
	public static final Set<Character> openingParanthesisSet = new HashSet<>();

	static {
		matchingParantheisMap.put('}', '{');
		matchingParantheisMap.put(']', '[');
		matchingParantheisMap.put(')', '(');
		openingParanthesisSet.addAll(matchingParantheisMap.values());
	}

	public static boolean hasMatchingParanthesis(String input) throws StackOverflowException, StackUnderFlowException {
		MyStack<Character> stack = new MyStack<>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			// push to stack if opening paranthesis is found
			if (openingParanthesisSet.contains(ch)) {
				stack.push(ch);
			}
			//if it's a closing paranthesis, pop the top element
			//to see the stack holds the matching open paranthesis
			if (matchingParantheisMap.containsKey(ch)) {
				Character lastOpenParanthesis = stack.pop();
				if (lastOpenParanthesis != matchingParantheisMap.get(ch)) {
					return false;
				}
			}
		}
		// if we run through entire string and the stack is empty at the end,
		// then it's all match
		return stack.isEmpty();
	}

	public static void main(String[] args) throws StackUnderFlowException, StackOverflowException {
		String input1 = "(abc) {def} [xyz(lmn)]";
		System.out.println(hasMatchingParanthesis(input1)); // true
		String input2 = "(abc {def} [xyz(lmn)]";
		System.out.println(hasMatchingParanthesis(input2)); // false
	}
}
