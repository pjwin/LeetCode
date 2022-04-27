package leetcode;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num.length(); i++){
            char cur = num.charAt(i);
            while (k > 0 && res.length() > 0 && res.charAt(res.length() - 1) > cur ){
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            if (res.length() == 0 && cur == '0') continue;
            res.append(cur);
        }

        while (k > 0 && res.length() > 0) {
            res.deleteCharAt(res.length() - 1);
            k--;
        }

        return res.length() == 0 ? "0" : res.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits rm = new RemoveKDigits();
        System.out.println(rm.removeKdigits("1432219", 3));
    }
}
