package leetcode;

public class LengthOfLastWord {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World")); //5
		System.out.println(lengthOfLastWord("World")); //5
		System.out.println(lengthOfLastWord("a ")); //1
		System.out.println(lengthOfLastWord(" a ")); //1
	}

	public static int lengthOfLastWord(String s) {
		return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
	}
}
