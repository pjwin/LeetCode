package leetcode;
import java.util.HashMap;

public class RomanNumeralToInteger {
    
	public int romanToInt(String s) {
		HashMap<Character, Integer> rn = new HashMap<>();
		rn.put('I', 1);
		rn.put('V', 5);
		rn.put('X', 10);
		rn.put('L', 50);
		rn.put('C', 100);
		rn.put('D', 500);
		rn.put('M', 1000);
		int sum = 0;
		int prev = 0;
		
		for (int i = 0; i < s.length(); i++ ) {
			int num = rn.get(s.charAt(i));
			if (num < prev) {
				sum -= num;
			} else {
				sum += num;
			}
			prev = num;
		}
		
		return sum;
    }
    
	public static void main(String[] args) {
		RomanNumeralToInteger s = new RomanNumeralToInteger();
		System.out.println(s.romanToInt("I"));
		System.out.println(s.romanToInt("II"));
		System.out.println(s.romanToInt("III"));
		System.out.println(s.romanToInt("IV"));
		System.out.println(s.romanToInt("V"));
		System.out.println(s.romanToInt("MMMCM"));
		System.out.println(s.romanToInt("MMMCMXCIX"));
	}
}
