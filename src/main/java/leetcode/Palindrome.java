package leetcode;

public class Palindrome {

	public static void main(String[] args) {
		isPalindrome2(191);
	}
	
	public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int test = x;
        long result = 0;
        while (x != 0) {
            result = (result * 10) + (x % 10);
            x = x / 10;
        }
        if ((int)result == test) {
            return true;
        } else {
            return false;
        }
    }
	
	public static boolean isPalindrome2(int x) {
	    if (x < 0 || (x != 0 && x % 10 == 0)) return false;
	    int rev = 0;
	    while (x > rev) {
	    	rev = rev * 10 + x % 10;
	    	x = x / 10;
	    }
	    return (x == rev || x == rev / 10);
	}
}
