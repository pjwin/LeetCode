package leetcode;

public class MaxSubArray {

	public static void main(String[] args) {
		System.out.println(maxSubArray2(new int [] {-2, 1, -3, 4, -1, 2, 1, -5, 4})); //6
		System.out.println(maxSubArray2(new int [] {-1, 2, 3, -4})); //5
		System.out.println(maxSubArray2(new int [] {-1, 2, -5})); //2
		System.out.println(maxSubArray2(new int [] {-1, 2, 3, 4, -5})); //9
	}

	public static int maxSubArray(int[] nums) {
		int start = 0;
		while (start < nums.length && nums[start] < 1) {
			start++;
		}
		int end = nums.length - 1;
		while (end >= 0 && nums[end] < 1) {
			end--;
		}
		if (start == end) return nums[start];
		if (end - start == 1) return nums[start] + nums[end];
		
		
		return 0;
	}
	
	public static int maxSubArray2(int[] nums) {
	    int maxSoFar = nums[0], maxEndingHere = nums[0];
	    for (int i = 1; i < nums.length; ++i){
	    	maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
	    	maxSoFar = Math.max(maxSoFar, maxEndingHere);	
	    }
	    return maxSoFar;
	}
}
