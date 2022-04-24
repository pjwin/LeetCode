package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumRollsToTarget {
    public int numRollsToTargetBottomUp(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= d; i++) { //loop through total number of dice
            System.out.println("------------------");
            System.out.println("i=" + i);
            for(int j = 1; j <= target; j++) { //loop through target values
                System.out.println("    j=" + j);
                for(int k = 1; k <= f; k++) { //loop through faces
                    System.out.println("        k=" + k);
                    if (k <= j) { //is the current face number less than or equal to the current target number?
                        System.out.println("            k(" + k + ") <= j(" + j +")");
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % 1000000007;
                        System.out.println("            dp[i(" + i + ")][j(" + j + ")]=" + dp[i][j]);
                        int x = i-1;
                        int y = j-k;
                        System.out.println("            dp[i - 1](" + x + ")[j - k](" + y + ")=" + dp[i - 1][j - k]);
                    } else {
                        System.out.println("            break");
                        break;
                    }
                }
            }
        }
        System.out.println();
        for (int i = 0; i <= target; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i = 0; i <= d; i++) {
            for(int j = 0; j <= target; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
            return dp[d][target];
    }

    public static void main(String[] args) {
        NumRollsToTarget nr = new NumRollsToTarget();
        System.out.println(nr.numRollsToTargetBottomUp(2, 6, 7));
    }
}
