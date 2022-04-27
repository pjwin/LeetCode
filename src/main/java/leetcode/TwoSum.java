package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] twoSum2pass(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int s = target - nums[i];
            if (numMap.containsKey(s) && numMap.get(s) != i) {
                return new int[] {i, numMap.get(s)};
            }
        }
        return null;
    }

    public int[] twoSum1pass(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int j;
        for (int i = 0; i < nums.length; i++) {
            j = target - nums[i];
            if (m.containsKey(j) && m.get(j) != i) {
                return new int[] {m.get(j), i};
            }
            m.put(nums[i], i);
        }
        return null;
    }
}
