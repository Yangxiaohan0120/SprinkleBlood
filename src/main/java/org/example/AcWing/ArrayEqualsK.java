package org.example.AcWing;

import java.util.Scanner;
/**
 * @author Chris Yang
 * created 2022-08-16 15:23
 **/
public class ArrayEqualsK {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s = scanner.nextLine();
            String[] ss = s.split(" ");
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(ss[j]);
            }
        }
        long res = findNumber(nums, k);
        System.out.println(res);
    }

    public static long findNumber(int[][] nums, int k) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] res = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1] - res[i - 1][j - 1] + nums[i - 1][j - 1];
            }
        }

        long ans = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                for (int s = 1, t = 1; t <= n; t++) {
                    while (s <= t && (res[j][t] + res[i - 1][s - 1] - res[i - 1][t] - res[j][s - 1]) > k) s++;
                    if (s <= t) ans += t - s + 1;
                }
            }
        }
        return ans;
    }
}
