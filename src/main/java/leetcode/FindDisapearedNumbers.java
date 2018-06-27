package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisapearedNumbers {

	public static void main(String[] args) {
		findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});

	}
    public static void findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
        	System.out.println(Arrays.toString(nums));
        	nums[(Math.abs(nums[i])-1) % n] = Math.abs(nums[(Math.abs(nums[i])-1) % n]) * -1;
        	System.out.println(Arrays.toString(nums) + "\n");
        }
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] > 0) {
        		res.add(i+1);
        	}
        }
        System.out.println(res.toString());
    }
}
