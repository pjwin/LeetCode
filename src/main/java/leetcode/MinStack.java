package leetcode;

public class MinStack {
	//https://leetcode.com/problems/min-stack/
    private class Node {
    	public int val;
    	public Node next, prev;
    }
	
    Node first;
    Node last;
    MinStack minStack;
    
	public MinStack() {
        
    }
    
    public void push(int x) {
        if (first == null) {
        	first = new Node();
        	first.val = x;
        	last = first;
        	minStack.push(x);
        } else {
        	Node newNode = new Node();
        	newNode.val = x;
        	last.next = newNode;
        	newNode.prev = last;
        	last = newNode;
        	if (x <= minStack.top()) minStack.push(x);
        }
    }
    
    public void pop() {
        
    }
    
    public int top() {
        return last == null ? 0 : last.val;
    }
    
    public int getMin() {
    	return minStack == null ? 0 : minStack.top();
    }
    
    public static void main(String[] args) {
    	MinStack minStack = new MinStack();
    	minStack.push(-2);
    	minStack.push(0);
    	minStack.push(-3);
    	minStack.getMin();   //--> Returns -3.
    	minStack.pop();
    	minStack.top();      //--> Returns 0.
    	minStack.getMin();   //--> Returns -2.
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