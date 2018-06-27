package leetcode;

import java.util.Arrays;

public class SingleNumber {

	public static void main(String[] args) {
		singleNumber(new int[] {1, 2, 2});
		singleNumber2(new int[] {1, 2, 2});
		singleNumber(new int[] {1, 2, 2, 4, 5, 4, 5, 1, 8, 9, 9});
		singleNumber2(new int[] {1, 2, 2, 4, 5, 4, 5, 1, 8, 9, 9});

	}
    public static void singleNumber(int[] nums) {
        System.out.println(Arrays.stream(nums).reduce(0, (x, y) -> x ^ y));
    }
    
    public static void singleNumber2(int[] nums) {
	    for (int i = 1; i < nums.length; i++) {
			nums[0] ^= nums[i];
	    }
		System.out.println(nums[0]);
    }
}
