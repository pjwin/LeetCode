package leetcode;

public class CountAndSay {

	public static void main(String[] args) {
//		System.out.println(countAndSay(1));
//		System.out.println(countAndSay(2));
		System.out.println(countAndSay(0));
	}
	
    public static String countAndSay(int n) {
    	String currString = null;
    	if (n > 1) {
    		currString = countAndSay(n - 1);
    	} else {
    		return "1";
    	}
    	
    	StringBuilder newString = new StringBuilder("");
    	int j = 1;
    	for(int i = 1; i < currString.length(); i++) {
    		if (currString.charAt(i) == currString.charAt(i - 1)) {
    			j++;
    		} else {
    			newString.append(j).append(currString.charAt(i - 1));
    			j = 1;
    		}
    	}
    	newString.append(j).append(currString.charAt(currString.length() - 1));
    	return newString.toString();
    }

}
