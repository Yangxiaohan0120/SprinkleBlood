package org.example.AcWing;

/**
 * @author Chris Yang
 * created 2022-10-10 16:52
 **/
public class ArrayPrintClockwise {
    public int[] printMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];

        int x2 = matrix.length - 1, y2 = matrix[0].length - 1;
        int x1 = 0, y1 = 0;
        int[] res = new int[matrix.length * matrix[0].length];
        int count = 0;
        while (true) {
            for (int i = y1; i <= y2; i++) {
                res[count++] = matrix[x1][i];
            }
            if (++x1 > x2) break;
            for (int i = x1; i <= x2; i++) {
                res[count++] = matrix[i][y2];
            }
            if (--y2 < y1) break;
            for (int i = y2; i >= y1; i--) {
                res[count++] = matrix[x2][i];
            }
            if (--x2 < x1) break;
            for (int i = x2; i >= x1; i--) {
                res[count++] = matrix[i][y1];
            }
            if (++y1 > y2) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] count = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[] res = new ArrayPrintClockwise().printMatrix(count);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ";");
        }
    }
}

