package leetcode;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.length() == 1) return false;

        int count = 0;
        Character s1 = null;
        Character s2 = null;
        Character g1 = null;
        Character g2 = null;

        int[] arr = new int[26];

        for (int i = 0; i < goal.length(); i++) {
            arr[s.charAt(i) - 'a'] += 1;
            if (s.charAt(i) == goal.charAt(i)) continue;
            if (++count > 2) return false; //too many differences
            if (s1 == null)  {
                s1 = s.charAt(i);
                g1 = goal.charAt(i);
            } else {
                s2 = s.charAt(i);
                g2 = goal.charAt(i);
            }
        }

        if (count == 0) {
            int freq = 0;
            for (int j: arr) {
                if (j > 1) return true;
            }
            return false;
        }

        return (s1 == g2 && s2 == g1);
    }
}
