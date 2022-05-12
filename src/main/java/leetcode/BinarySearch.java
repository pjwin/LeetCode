package leetcode;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + ((right - left) / 2);
        while (left <= right) {
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
            mid = left + ((right - left) / 2);
        }
        return -1;
    }
}
