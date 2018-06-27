package leetcode;

public class SearchInsert {

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] {1,3,5,6}, 5)); //2
		System.out.println(searchInsert(new int[] {1,3,5,6}, 2)); //1
		System.out.println(searchInsert(new int[] {1,3,5,6}, 7)); //4
		System.out.println(searchInsert(new int[] {1,3,5,6}, 0)); //0
		System.out.println(searchInsert(new int[] {}, 0)); //0
		System.out.println(searchInsert(new int[] {-3,0,3,5,6}, -1)); //1
	}
    public static int searchInsert2(int[] nums, int target) {
    	if (nums.length == 0) return 0;
    	for (int i = 0; i < nums.length; i++) {
    		if(target <= nums[i]) return i;
    	}
        return nums.length;
    }
    
    public static int searchInsert(int[] nums, int target) {
    	int low = 0;
    	int high = nums.length - 1;
    	while (low <= high) {
    		if (target < nums[(low + high) / 2])
    			high = (low + high) / 2 - 1;
    		else if (target > nums[(low + high) / 2])
    			low = (low + high) / 2 + 1;
    		else return (low + high) / 2;
    	}
    	return low;
    }
}
