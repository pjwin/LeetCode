package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		nextGreaterElement(new int[] {4, 1, 2}, new int[] {5,4,3,2,1,6});
		nextGreaterElement(new int[] {4, 1, 2}, new int[] {1,2,3,4,5,6,7,8,9,10});
		nextGreaterElement(new int[] {2, 4}, new int[] {1, 2, 3, 4});
		nextGreaterElement(new int[] {2, 4}, new int[] {4,3,2,1});
	}
	
    public static void nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        int ctr = 0;
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            	ctr++;
            stack.push(num);
            ctr++;
        }   
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        	ctr++;
        System.out.println(Arrays.toString(findNums));
        System.out.println(ctr);
    }
}
