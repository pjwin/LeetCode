package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
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

    public static void main(String[] args) {

    }

}
