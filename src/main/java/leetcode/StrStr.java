package leetcode;

public class StrStr {

	public static void main(String[] args) {
		System.out.println(strStr2("hello", "ll"));
		System.out.println(strStr2("aaaaa", "bba"));

	}

	public static int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	public static int strStr2(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}
}
