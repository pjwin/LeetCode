package leetcode;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueChar {

    public int firstUniqChar(String s) {
        char[] cArr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(cArr[i])) continue;
            if (s.indexOf(cArr[i]) == s.lastIndexOf(cArr[i])) return i;
            set.add(cArr[i]);
        }
        return -1;
    }

}
