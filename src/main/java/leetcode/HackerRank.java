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
    	int[] ok = new int[scores.length];
    	int j = 0;
    	for (int i = 0; i < scores.length - 1; i++) {
    		if (scores[i] != scores[i + 1]) {
    			ok[j++] = scores[i];
    		}
    	}
    	//add last element
    	ok[j] = scores[scores.length - 1];
    	//j now equals actual size of mynewScores.
    	
    	int rank = j + 2;
    	//go through each of alice's scores
    	for (int i = 0; i < alice.length; i++) {
    		if (j == 0) rank = 1;
    		
    		while (ok[j] <= alice[i] && j > 0) {
    			j--;
    			rank--;
    		}
    		
    		ranks[i] = rank;
    		System.out.println(rank);
    	}
        return ranks;
    }
    
	public static void main(String[] args) {
//		System.out.println(pageCount2(5, 4));
//		System.out.println(pageCount2(6, 2));
//		System.out.println(getMoneySpent(new int[] {3, 1}, new int[] {5, 2, 8}, 10));
//		System.out.println(formingMagicSquare(new int[][]{{4,8,2},{4,5,7},{6,1,6}}));
//		System.out.println(pickingNumbers(Arrays.asList(1,1,2,2,4,4,5,5,5)));
//		System.out.println(pickingNumbers(Arrays.asList(1,2,2,3,1,2)));
//		System.out.println(climbingLeaderboard(new int[] {100,90,90,80,75,60}, new int[] {50,50,65,77,90,102}));
		System.out.println(climbingLeaderboard(new int[] {295,294,291,287,287,285,285,284,283,279,277,274,274,271,270,268,268,268,264,260,259,258,257,255,252,250,244,241,240,237,236,236,231,227,227,227,226,225,224,223,216,212,200,197,196,194,193,189,188,187,183,182,178,177,173,171,169,165,143,140,137,135,133,130,130,130,128,127,122,120,116,114,113,109,106,103,99,92,85,81,69,68,63,63,63,61,57,51,47,46,38,30,28,25,22,15,14,12,6,4100,90,90,80,75,60}, new int[] {5,5,6,14,19,20,23,25,29,29,30,30,32,37,38,38,38,41,41,44,45,45,47,59,59,62,63,65,67,69,70,72,72,76,79,82,83,90,91,92,93,98,98,100,100,102,103,105,106,107,109,112,115,118,118,121,122,122,123,125,125,125,127,128,131,131,133,134,139,140,141,143,144,144,144,144,147,150,152,155,156,160,164,164,165,165,166,168,169,170,171,172,173,174,174,180,184,187,187,188,194,197,197,197,198,201,202,202,207,208,211,212,212,214,217,219,219,220,220,223,225,227,228,229,229,233,235,235,236,242,242,245,246,252,253,253,257,257,260,261,266,266,268,269,271,271,275,276,281,282,283,284,285,287,289,289,295,296,298,300,300,301,304,306,308,309,310,316,318,318,324,326,329,329,329,330,330,332,337,337,341,341,349,351,351,354,356,357,366,369,377,379,380,382,391,391,394,396,396,400}));
	}

}
