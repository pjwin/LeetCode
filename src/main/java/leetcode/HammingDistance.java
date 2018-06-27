package leetcode;

public class HammingDistance {

	public static void main(String[] args) {
		hammingDistance(1, 4);
	}
	
	public static void hammingDistance(int x, int y) {
		System.out.println(Integer.bitCount(x ^ y));
    }
}
