package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
	//https://leetcode.com/problems/min-stack/
	private List<Integer> myStack;
	
    public MinStack() {
    	myStack = new ArrayList<>();
    }
    
    public void push(int x) {
    	myStack.add(x);
    }
    
    public void pop() {
        myStack.remove(myStack.size() - 1);
    }
    
    public int top() {
    	return myStack.get(myStack.size() - 1);
    }
    
    public int getMin() {
    	return myStack.stream().mapToInt(x -> x).min().orElse(0);
    }
    
    public static void main(String[] args) {
    	MinStack minStack = new MinStack();
    	System.out.println(minStack.getMin());
    	minStack.push(-2);
    	minStack.push(0);
    	minStack.push(-3);
    	System.out.println(minStack.getMin());   //--> Returns -3.
    	minStack.pop();
    	System.out.println(minStack.top());      //--> Returns 0.
    	System.out.println(minStack.getMin());   //--> Returns -2.
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