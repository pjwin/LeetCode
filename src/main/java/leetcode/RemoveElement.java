package leetcode;

import java.util.Arrays;

public class RemoveElement {
	public static void main(String[] args) {
		int[] a1 = new int[] {3,2,2,3};
		System.out.println(removeElement(a1, 3));
		System.out.println(Arrays.toString(a1));
		int[] a2 = new int[] {0,1,2,2,3,0,4,2};
		System.out.println(removeElement(a2, 2));
		System.out.println(Arrays.toString(a2));
	}
	
    public static int removeElement(int[] nums, int val) {
    	if (nums.length == 0) return 0;
    	int j = 0;
    	for (int i = 0; i < nums.length; i++) {
    		while (nums[i] == val) {
    			i++;
    			if (i == nums.length) return j;
    		}
    		nums[j] = nums[i];
    		j++;
    	}
    	return j;
    }
}
