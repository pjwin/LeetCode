package leetcode;

public class RotateInteger {
    public int rotatedDigits(int n) {
        int count = 0;
        boolean found = false;
        StringBuilder sb = new StringBuilder();
        //0 = 0
        //1 = 1
        //2 = 5
        //3 = X
        //4 = X
        //5 = 2
        //6 = 9
        //7 = X
        //8 = 8
        //9 = 6

        if (n == 0 || n == 1) {
            return 0;
        }

        outerloop:
        for(int i = 1;i <= n; i++) {
            found = false;
            int j = i;
            while (j / 10 > 0) {
                int r = j % 10;
                if (r == 3 || r == 4 || r == 7) {
                    continue outerloop;
                } else if (r == 2 || r == 5 || r == 6 || r == 9) {
                    found = true;
                }
                j = j / 10;
            }
            if (j == 3 || j == 4 || j == 7) {
                continue outerloop;
            } else if (j == 2 || j == 5 || j == 6 || j == 9) {
                found = true;
            }
            if (found == true) count++;
        }


        return count;
    }
}
