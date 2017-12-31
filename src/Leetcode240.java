/**
 * Created by weiyao on 11/5/17.
 */
public class Leetcode240 {

    private static boolean matrixSearch(int[][] matrix, int target) {
        if (matrix.length <= 0) {
            return false;
        }
        return matrixSearchHelper(matrix, target, 0, matrix[0].length - 1, matrix.length);
    }

    private static boolean matrixSearchHelper(int[][] matrix, int target, int dim1, int dim2, int numRows) {
        if ((dim1 >= numRows) || (dim2 < 0)) {
            return false;
        } else if (matrix[dim1][dim2] == target) {
            return true;
        } else if (matrix[dim1][dim2] < target) {
            return matrixSearchHelper(matrix, target, dim1 + 1, dim2, numRows);
        } else {
            return matrixSearchHelper(matrix, target, dim1, dim2-1, numRows);
        }
    }

    public static void main(String[] args) {
        int[][] test = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        System.out.println(matrixSearch(test, -1));
    }
}
