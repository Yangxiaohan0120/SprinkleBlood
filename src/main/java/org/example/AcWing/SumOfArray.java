package org.example.AcWing;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-26 10:14
 **/
public class SumOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int[][] res = new int[m + 1][n + 1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                res[i][j] = nums[i - 1][j - 1] + res[i - 1][j] + res[i][j - 1] - res[i - 1][j - 1];
            }
        }
        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            System.out.println(SumOfArray(res, x1, y1, x2, y2));
        }
    }

    public static int SumOfArray(int[][] res, int x1, int y1, int x2, int y2) {
        return res[x2][y2] + res[x1 - 1][x2 - 1] - res[x1 - 1][y2] - res[x2][y1 - 1];
    }
}
