package leetcode;

import java.util.*;

public class MatrixDiagonalSort {
    public int[][] diagonalSort(int[][] mat) {

        //traverse top row
        for (int i = 0; i < mat[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0, k = i; j < mat.length && k < mat[0].length; j++, k++) {
                list.add(mat[j][k]);
            }
            Collections.sort(list);
            for (int j = 0, k = i; j < mat.length && k < mat[0].length; j++, k++) {
                mat[j][k] = list.remove(0);
            }
        }

        //traverse first column starting at 1
        for (int i = 1; i < mat.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0, k = i; j < mat[0].length && k < mat.length; j++, k++) {
                list.add(mat[k][j]);
            }
            Collections.sort(list);
            for (int j = 0, k = i; j < mat[0].length && k < mat.length; j++, k++) {
                mat[k][j] = list.remove(0);
            }
        }

        return mat;
    }

    public int[][] diagonalSort2(int[][] A) {
        int m = A.length, n = A[0].length;
        HashMap<Integer, PriorityQueue<Integer>> d = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                d.putIfAbsent(i - j, new PriorityQueue<>());
                d.get(i - j).add(A[i][j]);
            }
        }
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                A[i][j] = d.get(i - j).poll();
        return A;
    }
}
