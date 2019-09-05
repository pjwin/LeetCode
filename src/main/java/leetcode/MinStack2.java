package leetcode;

public class MinStack2 {
	//https://leetcode.com/problems/min-stack/
	private class Node {
		public int val;
		public Node prev;
	}
	Node last;
	
    public MinStack2() {
    	last = null;
    }
    
    public void push(int x) {
    	if (last == null) {
    		last = new Node();
    		last.val = x;
    	} else {
    		Node temp = new Node();
    		temp.val = x;
    		temp.prev = last;
    		last = temp;
    	}
    }
    
    public void pop() {
		last = last.prev;
    }
    
    public int top() {
    	return last == null ? 0 : last.val;
    }
    
    public int getMin() {
    	if (last == null) return 0;
    	if (last.prev == null) return last.val;
    	Node tmp = last.prev;
    	int min = last.val;
		while (tmp != null) {
			if (tmp.val < min) min = tmp.val;
			tmp = tmp.prev;
    	}
    	return min;
    }
    
    public static void main(String[] args) {
    	MinStack2 minStack = new MinStack2();
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