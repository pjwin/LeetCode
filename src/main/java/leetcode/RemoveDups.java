package leetcode;

import java.util.Arrays;

public class RemoveDups {

	public static void main(String[] args) {
		int[] a2 = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		long startTime = System.nanoTime();
		removeDups(a2);
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime); 
		startTime = System.nanoTime();
		removeDups2(a2);
		endTime = System.nanoTime();
		System.out.println(endTime - startTime); 

	}

	public static int removeDups(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return 1;
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			while (i < nums.length && nums[i] == nums[j-1]) {
				i++;
			}
			if (i < nums.length) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}
	
	public static int removeDups2(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return 1;
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			while (nums[i] == nums[j-1]) {
				i++;
				if (i == nums.length) return j;
			}
			nums[j] = nums[i];
			j++;
		}
		return j;
	}
}
