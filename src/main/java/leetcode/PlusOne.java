package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PlusOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] {9,9,9,9})));
		System.out.println(Arrays.toString(plusOne(new int[] {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6})));
	}

	public static int[] plusOne(int[] digits) {
		ArrayList<Integer> ans = Arrays.stream(digits).boxed().collect(Collectors.toCollection(ArrayList::new));
		boolean carry = true;
		for (int i = ans.size() - 1; i >= 0; i--) {
			if (carry) {
				if (ans.get(i) + 1 == 10) {
					ans.set(i, 0);
				} else {
					ans.set(i, ans.get(i) + 1);
					carry = false;
				}
			}
		}
		if (carry) {
			ans.add(0, 1);
		}
		return ans.stream().mapToInt(i -> i).toArray();
	}
}
