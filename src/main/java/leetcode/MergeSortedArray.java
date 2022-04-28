package leetcode;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
//		int[] arr1 = new int[] { 1, 2, 3, 0, 0, 0 };
//		int[] arr2 = new int[] { 2, 5, 6 };
//		merge(arr1, 3, arr2, 3);
//		System.out.println(Arrays.toString(arr1));
		int[] arr3 = new int[] { 0 };
		int[] arr4 = new int[] { 2 };
		merge2(arr3, 0, arr4, 1);
		System.out.println(Arrays.toString(arr3));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int a = 0;
		int b = 0;
		int[] temp = nums1.clone();
		for (int i = 0; i < m+n; i++) {
			if (a >= m) {
				nums1[i] = nums2[b];
				b++;
			}
			else if (b >= n) {
				nums1[i] = temp[a];
				a++;
			}
			else if (temp[a] < nums2[b]) {
				nums1[i] = temp[a];
				a++;				
			} else {
				nums1[i] = nums2[b];
				b++;
			}
		}
	}

	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int one = m - 1;
		int two = n - 1;
		for (int i = m + n - 1; i >= 0; i--) {
			if (one >= 0 && (two < 0 || nums1[one] > nums2[two])) {
				nums1[i] = nums1[one];
				one -= 1;
			} else if (one < 0 || nums1[one] <= nums2[two]) {
				nums1[i] = nums2[two];
				two -= 1;
			}
		}
	}
}
