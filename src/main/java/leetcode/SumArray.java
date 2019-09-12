package leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumArray {
	
	static int mysum(List<List<Integer>> arr) {
        int suma = 0;
        int sumb = 0;
        int len = arr.get(0).get(0);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            suma += arr.get(i + 1).get(i);
            sumb += arr.get(i + 1).get(len - i - 1);
        }
        return Math.abs(suma - sumb);
	}
	
	public static void main(String[] args) {
		List<List<Integer>> myarr = new ArrayList<>();
		myarr.add(Arrays.asList(3));
		myarr.add(Arrays.asList(11, 2, 4));
		myarr.add(Arrays.asList(4, 5, 6));
		myarr.add(Arrays.asList(10, 8, -12));
		List<Integer> mylist = new ArrayList<>();
		mylist.add(1);
		mylist.add(2);
		System.out.println(mylist.size());
		int count = 0, pos = 0, neg = 0, zero = 0;
		int[] two = new int[] {1, 2, 3};
		for (int myvar : two) {
//			if myvar
		}
		

//		System.out.println(new BigDecimal(1).divide(new BigDecimal(2), 6, BigDecimal.ROUND_UP));
//		System.out.println(new BigDecimal(1).divide(new BigDecimal(3), 6, BigDecimal.ROUND_UP));
//		System.out.println(new BigDecimal(1).divide(new BigDecimal(6), 6, BigDecimal.ROUND_UP));
		
		StringBuilder sb = new StringBuilder();
		sb.append(" #");
		System.out.println(sb);
		sb.replace(0, 1, "#");
		System.out.println(sb);
				
		
		
	}
}
