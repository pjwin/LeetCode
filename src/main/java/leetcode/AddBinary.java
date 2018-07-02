package leetcode;

public class AddBinary {
	public static void main(String[] args) {
//		 System.out.println(addBinarySolution("11", "1"));
		 System.out.println(addBinarySolution("1010", "10111"));
//		System.out.println(addBinarySolution(
//				"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
//				"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));

		// StringBuilder test = new StringBuilder(3);
		// test.insert(0, '0');
		// test.insert(1, '1');
		// System.out.println(test.toString());
		// System.out.println(test.reverse().toString());

	}

	public static String addBinary2(String a, String b) {
		StringBuilder asb = new StringBuilder(a);
		asb.reverse();
		StringBuilder bsb = new StringBuilder(b);
		bsb.reverse();
		int max = Integer.max(a.length(), b.length());
		StringBuilder ans = new StringBuilder();
		boolean carry = false;
		for (int i = 0; i < max; i++) {
			if (i >= asb.length()) { // reached end of a?
				if (carry) {
					if (bsb.charAt(i) == '1') {
						ans.append('0');
					} else {
						ans.append('1');
						carry = false;
					}
				} else {
					ans.append(bsb.charAt(i));
				}
			} else if (i >= bsb.length()) { // reached end of b?
				if (carry) {
					if (asb.charAt(i) == '1') {
						ans.append('0');
					} else {
						ans.append('1');
						carry = false;
					}
				} else {
					ans.append(asb.charAt(i));
				}
			} else if (carry) { // i < a.length && i < b.length
				if (asb.charAt(i) == '0' && bsb.charAt(i) == '0') {
					ans.append('1');
					carry = false;
				} else if (asb.charAt(i) == '1' && bsb.charAt(i) == '1') {
					ans.append('1');
				} else {
					ans.append('0');
				}
			} else {
				if (asb.charAt(i) == '0') {
					ans.append(bsb.charAt(i));
				} else if (bsb.charAt(i) == '0') {
					ans.append(asb.charAt(i));
				} else {
					ans.append('0');
					carry = true;
				}
			}
		}
		if (carry) {
			ans.append('1');
		}
		return ans.reverse().toString();
	}
	
	public static String addBinary3(String a, String b) {
		StringBuilder asb = new StringBuilder(a);
		asb.reverse();
		StringBuilder bsb = new StringBuilder(b);
		bsb.reverse();
		int max = Integer.max(a.length(), b.length());
		StringBuilder ans = new StringBuilder();
		boolean carry = false;
		for (int i = 0; i < max; i++) {
			if (i >= asb.length()) { // reached end of a?
				if (carry) {
					if (bsb.charAt(i) == '1') {
						ans.append('0');
					} else {
						ans.append('1');
						carry = false;
					}
				} else {
					ans.append(bsb.charAt(i));
				}
			} else if (i >= bsb.length()) { // reached end of b?
				if (carry) {
					if (asb.charAt(i) == '1') {
						ans.append('0');
					} else {
						ans.append('1');
						carry = false;
					}
				} else {
					ans.append(asb.charAt(i));
				}
			} else if (carry) { // i < a.length && i < b.length
				if (asb.charAt(i) == '0' && bsb.charAt(i) == '0') {
					ans.append('1');
					carry = false;
				} else if (asb.charAt(i) == '1' && bsb.charAt(i) == '1') {
					ans.append('1');
				} else {
					ans.append('0');
				}
			} else {
				if (asb.charAt(i) == '0') {
					ans.append(bsb.charAt(i));
				} else if (bsb.charAt(i) == '0') {
					ans.append(asb.charAt(i));
				} else {
					ans.append('0');
					carry = true;
				}
			}
		}
		if (carry) {
			ans.append('1');
		}
		return ans.reverse().toString();
	}

	public static String addBinary1(String a, String b) {
		return Long.toBinaryString(Long.parseLong(a, 2) + Long.parseLong(b, 2));
	}

	public static String addBinarySolution(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}
}
