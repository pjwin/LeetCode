package leetcode;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        //binary search the first element of each row in the matrix
        int top = 0;
        int bottom = matrix.length - 1;

        while (top <= bottom) {
            int mid = top + ((bottom - top) / 2);
            if (target == matrix[mid][0]) return true;
            if (target > matrix[mid][0]) top = mid + 1;
            else bottom = mid - 1;
        }

        //binary search the row for the element
        int left = 0;
        bottom = Math.max(bottom, 0);
        int right = matrix[bottom].length > 0 ? matrix[bottom].length - 1 : 0;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (target == matrix[bottom][mid]) return true;
            if (target > matrix[bottom][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            }
            if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
