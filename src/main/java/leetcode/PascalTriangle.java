package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
//		pt.generate(4);
//		System.out.println(Arrays.asList(pt.generate(10)));
		System.out.println(Arrays.asList(pt.getRow2(3)));
	}
    
    
    public List<Integer> getRow2(int rowIndex) {
		if (rowIndex < 0) return null;
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i++) {
			result.add(0, 1);
			for (int j = 1; j < i; j++) {
				result.set(j, result.get(j) + result.get(j+1));
			}
		}
		return result;
    }
    
    public List<Integer> getRow(int rowIndex) {
    	if (rowIndex < 0) return null;
    	List<Integer> result = new ArrayList<Integer>();
    	for (int i = 0; i <= rowIndex; i++) {
    		List<Integer> row = new ArrayList<Integer>();
    		for (int j = 0; j <= i; j++) {
    			if (j == 0 || j == i) {
    				row.add(1);
    			} else {
    				row.add(result.get(j) + result.get(j-1));
    			}
    		}
    		result = row;
    	}
    	return result;
    }

	public List<List<Integer>> generate(int numRows) {
		if (numRows < 0) return null;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(result.get(i - 1).get(j) + result.get(i - 1).get(j-1));
				}
			}
			result.add(row);
		}
		return result;
    }
}
