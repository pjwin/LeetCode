package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HackerRank {

    static int pageCount(int n, int p) {
        if (p > n / 2) p = n - p + (n % 2 == 0 ? 1 : 0 );
        return p / 2;
    }
    
    static int pageCount2(int n, int p) {
        return Math.min(p / 2, n / 2 - p / 2);
    }
    
    
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
    	Arrays.sort(keyboards);
    	for (int i = 0; i < keyboards.length / 2; i++) {
            int temp = keyboards[i];
            keyboards[i] = keyboards[keyboards.length - 1 - i];
            keyboards[keyboards.length - 1 - i] = temp;
        }
    	Arrays.sort(drives);
    	
    	int n = keyboards.length;
    	int m = drives.length;
    	int max = -1;
    	
    	for(int i = 0, j = 0; i < n; i++){
            for(; j < m; j++){
                if(keyboards[i]+drives[j] > b) break; //This prevents j from incrementing
                if(keyboards[i]+drives[j] > max)
                    max = keyboards[i]+drives[j];
            }
        }
    	
    	return max;
    }
    
    static int formingMagicSquare(int[][] s) {
    	
    	int[][] pre = new int[][]{
    	    {8,1,6,3,5,7,4,9,2},
    	    {6,1,8,7,5,3,2,9,4},
    	    {4,9,2,3,5,7,8,1,6},
    	    {2,9,4,7,5,3,6,1,8},
    	    {8,3,4,1,5,9,6,7,2},
    	    {4,3,8,9,5,1,2,7,6},
    	    {6,7,2,1,5,9,8,3,4},
    	    {2,7,6,9,5,1,4,3,8}
    	};
    	
    	int[] nums = new int[9];
    	int count = 0;
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			nums[count] = s[i][j];
    			count++;
    		}
    	}
    	
    	int[] totals = new int[8];
    	int total = 0;
    	int[] p = new int[9];
    	for (int i = 0; i < 8; i++) {
    		total = 0;
    		p = pre[i];
    		for (int j = 0; j < 9; j++) {
    			total += Math.abs(p[j] - nums[j]);
    		}
    		totals[i] = total;
    	}
    	
    	int min = Integer.MAX_VALUE;
    	for (int i : totals) {
    		if (i < min) min = i;
    	}
    	
        return min;
    }
    
    public static int pickingNumbers(List<Integer> a) {
    	Map<Integer, Integer> mymap = new HashMap<>();
    	for (int i: a) {
    		mymap.put(i, mymap.getOrDefault(i, 0) + 1);
    	}
    	int max = Collections.max(mymap.values());
    	int tmp = 0;
    	for (Integer key : mymap.keySet()) {
    		tmp = mymap.get(key) + mymap.getOrDefault(key + 1, 0);
    		if (tmp > max) max = tmp;
    	}
    	return max;
    }
    
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
    	//create return array;
    	int[] ranks = new int[alice.length];

    	//remove dups from scores
    	int[] mynewScores = new int[scores.length];
    	int j = 0;
    	for (int i = 0; i < scores.length - 1; i++) {
    		if (scores[i] != scores[i + 1]) {
    			mynewScores[j++] = scores[i];
    		}
    	}
    	//add last element
    	mynewScores[j++] = scores[scores.length - 1];
    	//j now equals actual size of mynewScores.
    	
    	//go through each of alice's scores
    	for (int i = 0; i < alice.length; i++) {
//    		while (alice[i] > )
    	}
        
                
        
        return ranks;

    }
    
    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        int y = 0;
        for (int x = i; x <= j; x++) {
            y = Integer.valueOf(new StringBuilder(Integer.toString(x)).reverse().toString());
            if (Math.abs(x - y) % k == 0) count++;
        }
        return count;
    }
    
    static int viralAdvertising(int n) {
        int shared = 5;
        int liked = 2;
        int cumulative = 2;
        for (int i = 2; i <= n; i++) {
            shared = liked * 3;
            liked = shared / 2;
            cumulative += liked;
        }

        return cumulative;
    }
    
	public static void main(String[] args) {
//		System.out.println(pageCount2(5, 4));
//		System.out.println(pageCount2(6, 2));
//		System.out.println(getMoneySpent(new int[] {3, 1}, new int[] {5, 2, 8}, 10));
//		System.out.println(formingMagicSquare(new int[][]{{4,8,2},{4,5,7},{6,1,6}}));
//		System.out.println(pickingNumbers(Arrays.asList(1,1,2,2,4,4,5,5,5)));
//		System.out.println(pickingNumbers(Arrays.asList(1,2,2,3,1,2)));
//		System.out.println(climbingLeaderboard(new int[] {100,90,90,80,75,60}, new int[] {50, 65,77,90,102}));
//		System.out.println(beautifulDays(20, 23, 6));
//		System.out.println(viralAdvertising(3));
		System.out.println(3 % 5);
		System.out.println(-3 % 5);
		System.out.println(3 % -5);
		System.out.println(-3 % -5);
		
	}

}
