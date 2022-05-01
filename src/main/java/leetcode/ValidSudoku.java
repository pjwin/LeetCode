package leetcode;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        //brute force = check rows, then columns, then 3x3s
        //max 3 x 9 x 9 total loop iterations

        //check rows
        for (int i = 0; i < 9; i++) { //rows
            int[] temp = new int[9];
            for (int j = 0; j < 9; j++) { //columns
                char c = board[i][j];
                if (c != '.') {
                    int k = Character.getNumericValue(c);
                    if (temp[k - 1] == 1) {
                        return false;
                    } else {
                        temp[k - 1] = 1;
                    }
                }
            }
        }

        //check columns
        for (int i = 0; i < 9; i++) { //rows
            int[] temp = new int[9];
            for (int j = 0; j < 9; j++) { //columns
                char c = board[j][i];
                if (c != '.') {
                    int k = Character.getNumericValue(c);
                    if (temp[k - 1] == 1) {
                        return false;
                    } else {
                        temp[k - 1] = 1;
                    }
                }
            }
        }

        //check 3x3
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                //3x3 start position
                int[] temp = new int[9];
                for (int c = i; c < i + 3; c++) {
                    for (int r = j; r < j + 3; r++) {
                        char ch = board[c][r];
                        if (ch != '.') {
                            int k = Character.getNumericValue(ch);
                            if (temp[k - 1] == 1) {
                                return false;
                            } else {
                                temp[k - 1] = 1;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
