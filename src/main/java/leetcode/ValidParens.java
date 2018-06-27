package leetcode;

import java.util.Stack;

public class ValidParens {

	public static void main(String[] args) {
		System.out.println(validParens("()")); //true
		System.out.println(validParens("()[]{}")); //true
		System.out.println(validParens("(]")); //false
		System.out.println(validParens("([)]")); //false
		System.out.println(validParens("{[]}")); //true
		System.out.println(validParens("")); //true
		System.out.println(validParens("[][][][][][]({({({({({})})})})})")); //true
		System.out.println(validParens("[")); //false
	}
	
	public static Boolean validParens(String s) {
		Stack<Character> cs = new Stack<>();
		for (char c: s.toCharArray()) {
			switch (c) {
				case '(':
				case '[':
				case '{':
					cs.push(c);
					break;
				case ')':
					if (!cs.isEmpty() && cs.peek().equals('(')) {
						cs.pop();
					} else {
						return false;
					}
					break;
				case ']':
					if (!cs.isEmpty() && cs.peek().equals('[')) {
						cs.pop();
					} else {
						return false;
					}
					break;
				case '}':
					if (!cs.isEmpty() && cs.peek().equals('{')) {
						cs.pop();
					} else {
						return false;
					}
					break;
			}
		}
		return cs.isEmpty();
	}
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
