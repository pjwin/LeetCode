package hackerrank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HackerRank {

    static long aVeryBigSum(long[] ar) {
        long sum = 0;
        for (long x: ar){
            sum += x;
        }
        return sum;
    }
    
    public static int diagonalDifference(List<List<Integer>> arr) {
        int suma = 0;
        int sumb = 0;
        List<Integer> mylist = arr.get(0);
        int len = arr.get(0).size();
        for (int i = 0; i < len; i++) {
            suma += arr.get(i).get(i);
            sumb += arr.get(i).get(len - i - 1);
        }
        return Math.abs(suma - sumb);
    }
    
    static void plusMinus(int[] arr) {
        int count = 0;
        int pos = 0;
        int neg = 0;
        int zero = 0;

        for (int x : arr){
            if (x < 0) {
                neg++;
            } else if (x > 0) {
                pos++;
            } else {
                zero++;
            }
        }
        count = zero + neg + pos;
        System.out.println(new BigDecimal(pos).divide(new BigDecimal(count), 6, BigDecimal.ROUND_UP));
        System.out.println(new BigDecimal(neg).divide(new BigDecimal(count), 6, BigDecimal.ROUND_UP));
        System.out.println(new BigDecimal(zero).divide(new BigDecimal(count), 6, BigDecimal.ROUND_UP));
    }

    
    static void staircase(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        //eg for n = 6: sb = 012345
        for (int i = n; i > 0; i--) {
            sb.replace(i - 1, i, "#");
            System.out.println(sb);
        }

    }
    
    static void miniMaxSum(int[] arr) {
        long min = Integer.MAX_VALUE;
        long max = 0;
        long sum = 0;
        for (int x : arr) {
            sum += x;
            if (x < min) min = x;
            if (x > max) max = x;
        }
        min = sum - min;
        max = sum - max;

        System.out.println(max + " " + min);

    }
    
    static int birthdayCakeCandles(int[] ar) {
        int max = 0;
        int count = 0;
        for (int x : ar) {
            if (x > max) {
                max = x;
                count = 1;
            } else if (x == max) {
                count++;
            }
        }
        return count;
    }
    
    static String timeConversion(String s) {
        if (s.startsWith("12")) {
            if (s.contains("AM")) {
                return "00" + s.substring(2,8);
            } else {
                return s.substring(0,8);
            }
        }
        else if (s.contains("AM")) {
            return s.substring(0,8);
        } else {
            return String.valueOf(Integer.valueOf(s.substring(0,2)) + 12) + s.substring(2,8);
        }

    }
    
    public static List<Integer> gradingStudents(List<Integer> grades) {
        int i = 0;
        for (int x : grades){
            if (x >= 38) {
                if ((x + 1) % 5 == 0) {
                    grades.set(i, new Integer(x + 1));
                } else if ((x + 2) % 5 == 0) {
                    grades.set(i, new Integer(x + 2));
                }
            }
            i++;
        }
        return grades;
    }
    
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleTotal = 0;
        int orangeTotal = 0;
        for (int apple : apples) {
            if (a + apple >= s && a + apple <= t) appleTotal++;
        }
        for (int orange : oranges) {
            if (b + orange >= s && b + orange <= t) orangeTotal++;
        }
        System.out.println(appleTotal);
        System.out.println(orangeTotal);
    }
    
    static String kangaroo(int x1, int v1, int x2, int v2) {
        int hop = 0;
        while (true) {
            if (x1 == x2 && hop > 0) {
                return "YES";
            } else if ((x1 >= x2 && v1 > v2) || (x1 <= x2 && v1 < v2) || (x1 != x2 && v1 == v2)){
                return "NO";
            } else {
                hop++;
                x1 += v1;
                x2 += v2;
            }
        }
    }
    
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int count = 0;
        int amax = Collections.max(a);
        int bmin = Collections.min(b);
        for (int i = amax; i <= bmin; i ++) {
            int temp = 0;
            for (int num : a) {
                temp += i % num;
                if (temp > 0) break;
            }
            if (temp > 0) continue;
            for (int num : b) {
                temp += num % i;
                if (temp > 0) break;
            }
            if (temp > 0) continue;
            count++;
        }
        return count;
    }
    
    static int[] breakingRecords(int[] scores) {
        int min = scores[0];
        int max = scores[0];
        int mincount = 0;
        int maxcount = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
                mincount++;
            }
            else if (scores[i] > max) {
                max = scores[i];
                maxcount++;
            }
        }
        return new int[]{maxcount, mincount};
    }
    
    static int birthday(List<Integer> s, int d, int m) {
        int currentTotal = 0;
        int count = 0;
        //prime the loop
        //add to the current total the first m numbers in s
        for (int i = 0; i < m && i < s.size(); i++) {
            if (s.get(i) == null) return 0; //stop if there aren't even m numbers
            currentTotal += s.get(i); //add the ith number to currentTotal
        }
        if (currentTotal == d) count++; //did the first m numbers = d?
        int i = m; //start counting at m position of s (zero based)
        while (i < s.size()) { //loop until list is empty
            currentTotal += s.get(i); //add current position to total
            currentTotal -= s.get(i - m); //subtract number at the start
            if (currentTotal == d) count++; //add to count
            i++;
        }
        return count;
    }
    
    static int divisibleSumPairs(int n, int k, int[] ar) {
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if ((ar[i] + ar[j]) % k == 0) count ++;
            }
        }
        return count;
    }
    
    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> mymap = new HashMap<>();
        for (int a : arr){
            mymap.put(a, mymap.getOrDefault(a, 0) + 1);
        }
        return Collections.max(mymap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
    }
    
    static String dayOfProgrammer(int year) {
        String dd = "00";
        String mm = "09";
        if (year <= 1917) {
            if (year % 4 == 0) {
                dd = "12";
            } else {
                dd = "13";
            }
        } else if (year == 1918) {
            dd = "26";
        } else {
            if (year % 4 == 0) {
                if (year % 100 == 0 && year % 400 != 0) {
                    dd = "13";
                } else {
                    dd = "12";
                }
            } else {
                dd = "13";
            }
        }
        return dd + "." + mm + "." + year;
    }
    
    static void bonAppetit(List<Integer> bill, int k, int b) {
        int count = 0;
        int bact = 0;
        int skip = 0;
        for (int i : bill) {
            if (count == k) {
                skip = i;
            }
            bact += i;
            count++;
        }
        //bact is now the total items charged.
        //skip stores the price of the item anna didnt eat.
        //subtract it from total. then divide by 2.
        bact -= skip;
        bact /= 2;
        if (bact == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(skip / 2);
        }
    }
    
    static int sockMerchant(int n, int[] ar) {
        int total = 0;
        Map<Integer, Integer> mymap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mymap.put(ar[i], mymap.getOrDefault(ar[i], 0) + 1);
        }
        for (int i : mymap.values()) {
            total += i / 2;
        }
        return total;
    }
    
    static int pageCount(int n, int p) {
        if (p > n / 2) p = n - p + (n % 2 == 0 ? 1 : 0 );
        return p / 2;
    }
    
    static int pageCount2(int n, int p) {
        return Math.min(p / 2, n / 2 - p / 2);
    }
    
    static int countingValleys(int n, String s) {
        int count = 0;
        int height = 0;
        boolean invalley = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'U') {
                height++;
                if (invalley && height == 0) count++;
            } else {
                height--;
                if (height < 0 && !invalley) invalley = true;
            }
        }
        return count;
    }
    
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int bill = 0;
        int tmp = 0;
        for (int k : keyboards) {
            for (int d : drives) {
                tmp = k + d;
                if (tmp > bill && tmp <= b)
                bill = tmp;
                if (bill == b) return b;
            }
        }
        return bill == 0 ? -1 : bill;
    }
    
    static String catAndMouse(int x, int y, int z) {
        x = Math.abs(x - z);
        y = Math.abs(y - z);
        if (x == y) {
            return "Mouse C";
        } else if (x < y) {
            return "Cat A";
        } else {
            return "Cat B";
        }
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
        
        return Arrays.stream(totals).min().getAsInt();

    }
    
    public static int pickingNumbers(List<Integer> a) {
        Map<Integer, Integer> mymap = new HashMap<>();
        for (int i: a) {
            mymap.put(i, mymap.getOrDefault(i, 0) + 1);
        }
        int max = Collections.max(mymap.values());
        int tmp = 0;
        for (Integer key : mymap.keySet()) {
            tmp = mymap.get(key) + mymap.getOrDefault(key - 1, 0);
            if (tmp > max) max = tmp;
            tmp = mymap.get(key) + mymap.getOrDefault(key + 1, 0);
            if (tmp > max) max = tmp;
        }
        return max;
    }
    
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        //create return array;
        int[] ranks = new int[alice.length];

        //remove dups from scores
        int[] newlist = new int[scores.length];
        int j = 0;
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] != scores[i + 1]) {
                newlist[j++] = scores[i];
            }
        }
        //add last element
        newlist[j] = scores[scores.length - 1];
        //j now equals actual size of mynewScores.
        ////////////////////////////////////////////
        
        
        int rank = j + 2;
        //go through each of alice's scores
        for (int i = 0; i < alice.length; i++) {
            if (j == 0) {
                rank = alice[i] >= newlist[j] ? 1 : 2;
            } else {
                while (newlist[j] <= alice[i] && j > 0) {
                    j--;
                }
                if (j == 0) {
                    rank = alice[i] >= newlist[j] ? 1 : 2;
                } else {
                    rank = j + 2;
                }
            }
            
            ranks[i] = rank;
            System.out.println(rank);
        }
        return ranks;
    }
    
    static int hurdleRace(int k, int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) max = height[i];
        }
        return max > k ? max - k : 0;
    }
    
    static int designerPdfViewer(int[] h, String word) {
        int max = 0;
        int mychar = 0;
        for (int i = 0; i < word.length(); i++) {
            mychar = ((int) word.charAt(i)) - 97;
            if (h[mychar] > max) max = h[mychar];
        }

        return max * word.length();
    }
    
    static int utopianTree(int n) {
        int height = 1;
        if (n == 0) return 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                height++;
            } else {
                height *= 2;
            }
        }
        return height;
    }
    
    static String angryProfessor(int k, int[] a) {
        if (k == 0) return "NO";
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0) count++;
            if (count == k) return "NO";
        }

        return "YES";
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
    
    static int saveThePrisoner(int n, int m, int s) {
        int l = m - (n - (s - 1));
        if (l < 0) return n + l;
        return l % n == 0 ? n : l % n;
    }
    
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int[] values = new int[queries.length];
        k = k % a.length;
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] - k >= 0) {
                values[i] = a[queries[i] - k];
            } else {
                values[i] = a[a.length - k + queries[i]];
            }
        }
        return values;
    }
    
    static int[] permutationEquation(int[] p) {
        int[] q = new int[p.length];
        int[] r = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            q[p[i] - 1] = i + 1;
        }
        for (int i = 0; i < p.length; i++) {
            r[i] = q[q[i] - 1];
        }
        return r;
    }
    
    static int findDigits(int n) {
        int count = 0;
        String temp = Integer.toString(n);
        for (int i = 0; i < temp.length(); i++)
        {
            if ((temp.charAt(i) - '0') != 0 && n % (temp.charAt(i) - '0') == 0) count++;
        }
        
        return count;
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
//		System.out.println(circularArrayRotation(new int[] {1,2,3,}, 2, new int[] {0,1,2}));
//		System.out.println(permutationEquation(new int[] {5,2,1,3,4}));
//		System.out.println(findDigits(1012));
//		System.out.println(climbingLeaderboard(new int[] {100,90,90,80,75,60}, new int[] {50,50,65,77,90,102}));
//		System.out.println(climbingLeaderboard(new int[] {295,294,291,287,287,285,285,284,283,279,277,274,274,271,270,268,268,268,264,260,259,258,257,255,252,250,244,241,240,237,236,236,231,227,227,227,226,225,224,223,216,212,200,197,196,194,193,189,188,187,183,182,178,177,173,171,169,165,143,140,137,135,133,130,130,130,128,127,122,120,116,114,113,109,106,103,99,92,85,81,69,68,63,63,63,61,57,51,47,46,38,30,28,25,22,15,14,12,6,4100,90,90,80,75,60}, new int[] {5,5,6,14,19,20,23,25,29,29,30,30,32,37,38,38,38,41,41,44,45,45,47,59,59,62,63,65,67,69,70,72,72,76,79,82,83,90,91,92,93,98,98,100,100,102,103,105,106,107,109,112,115,118,118,121,122,122,123,125,125,125,127,128,131,131,133,134,139,140,141,143,144,144,144,144,147,150,152,155,156,160,164,164,165,165,166,168,169,170,171,172,173,174,174,180,184,187,187,188,194,197,197,197,198,201,202,202,207,208,211,212,212,214,217,219,219,220,220,223,225,227,228,229,229,233,235,235,236,242,242,245,246,252,253,253,257,257,260,261,266,266,268,269,271,271,275,276,281,282,283,284,285,287,289,289,295,296,298,300,300,301,304,306,308,309,310,316,318,318,324,326,329,329,329,330,330,332,337,337,341,341,349,351,351,354,356,357,366,369,377,379,380,382,391,391,394,396,396,400}));
		
		int[] arr = new int[] {1,2,3};
		for(int i = 0; i < arr.length; i++) System.out.println(arr[i]);
		
	}

}
