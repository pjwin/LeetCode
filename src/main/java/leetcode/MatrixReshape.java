package leetcode;

public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) return mat; //illegal reshape

        int count = 0;
        int[] t = new int[mat.length * mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                t[count] = mat[i][j];
                count++;
            }
        }

        count = 0;
        int[][] ret = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = t[count];
                count++;
            }
        }
        return ret;

    }
}
