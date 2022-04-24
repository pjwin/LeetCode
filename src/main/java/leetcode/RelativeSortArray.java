package leetcode;

import java.util.*;

class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> arr1Map = new HashMap<>();
        for (int i=0; i<arr1.length; i++) {
            if (arr1Map.get(arr1[i]) == null) {
                arr1Map.put(arr1[i], 1);
            } else {
                arr1Map.replace(arr1[i], arr1Map.get(arr1[i]) +1);
            }
        }

        List<Integer> retList = new ArrayList<>();
        for (int i=0; i<arr2.length; i++) {
            int j = arr1Map.get(arr2[i]);
            while (j>0) {
                retList.add(arr2[i]);
                j -= 1;
            }
            arr1Map.remove(arr2[i]);
        }

        List<Integer> tempList = new ArrayList<>();
        for (int i: arr1Map.keySet()) {
            int j = arr1Map.get(i);
            while (j>0) {
                tempList.add(i);
                j -= 1;
            }
        }

        // tempList.sort();
        Collections.sort(tempList);
        for (int i: tempList) {
            retList.add(i);
        }

        // for (int i: retList) {
        //     System.out.println(i);
        // }

        return retList.stream().mapToInt(Integer::intValue)
                .toArray();

    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for(int n : arr1) cnt[n]++;
        int i = 0;
        for(int n : arr2) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for(int n = 0; n < cnt.length; n++) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}