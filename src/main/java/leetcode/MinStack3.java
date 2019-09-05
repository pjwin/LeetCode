package leetcode;

import java.util.Stack;

public class MinStack3 {
	//https://leetcode.com/problems/min-stack/
	Stack<Integer> myStack;
	
    public MinStack3() {
    	myStack = new Stack<>();
    }
    
    public void push(int x) {
    	myStack.add(x);
    }
    
    public void pop() {
    	myStack.pop();
    }
    
    public int top() {
    	return myStack.peek();
    }
    
    public int getMin() {
    	return myStack.parallelStream().mapToInt(x -> x).min().orElse(0);
    }
    
    public static void main(String[] args) {
    	MinStack3 minStack = new MinStack3();
    	System.out.println(minStack.getMin());
    	minStack.push(2147483646);
    	minStack.push(2147483646);
    	minStack.push(2147483647);
    	System.out.println(minStack.top());
    	minStack.pop();
    	System.out.println(minStack.getMin());
    	minStack.pop();
    	System.out.println(minStack.getMin());
    	minStack.pop();
    	minStack.push(2147483647);
    	System.out.println(minStack.top());
    	System.out.println(minStack.getMin());
    	minStack.push(-2147483648);
    	System.out.println(minStack.top());
    	System.out.println(minStack.getMin());
    	minStack.pop();
    	System.out.println(minStack.getMin());
	}
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */