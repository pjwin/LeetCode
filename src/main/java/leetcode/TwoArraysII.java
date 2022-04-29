package leetcode;

import java.util.*;

public class TwoArraysII {

    public int[] intersect2(int[] nums1, int[] nums2) {
        int[] numsone = new int[1001];
        int[] numstwo = new int[1001];
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) { //load numone
            numsone[nums1[i]] += 1;
        }
        for (int i = 0; i < nums2.length; i++) { //load numtwo
            numstwo[nums2[i]] += 1;
        }

        for (int i = 0; i < 1001; i++) { //loop numone looking for match in numtwo
            if (numsone[i] < 1 || numstwo[i] < 1) continue;
            else {
                for (int j = 1; j <= Math.min(numsone[i], numstwo[i]); j++) {
                    ret.add(i);
                }
            }
        }

        return ret.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        int k = 0;

        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {

    }

}
