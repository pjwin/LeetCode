package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		longestCommonPrefix(new String[] {"flower", "flow", "flight"});
		longestCommonPrefix(new String[] {"dog", "racecar", "car"});
	}
	
    public static String longestCommonPrefix2(String[] strs) {
    	System.out.println(Arrays.toString(strs));
//    	List<String> mylist = Arrays.asList(strs);
//    	mylist.sort(String::compareToIgnoreCase);
//    	System.out.println(mylist);
    	if (strs.length == 0) return "";
    	String res = strs[0];
    	int len = strs[0].length();
    	for (int i = 1; i < strs.length; i++) {
    		len = Integer.min(len, strs[i].length());
    		while (len > 0 && !res.substring(0, len).equalsIgnoreCase(strs[i].substring(0, len))) {
    			len -= 1;
    		}
    		res = res.substring(0, len);
    		if (len == 0) break;
    	}
    	System.out.println(res);
    	return res;
    }
    
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
    	String res = strs[0];
    	int len = strs[0].length();
    	for (int i = 1; i < strs.length; i++) {
    		len = Integer.min(len, strs[i].length());
    		while (len > 0 && !res.substring(0, len).equalsIgnoreCase(strs[i].substring(0, len))) {
    			len -= 1;
    		}
    		res = res.substring(0, len);
    		if (len == 0) break;
    	}
    	return res; 
    }
}
