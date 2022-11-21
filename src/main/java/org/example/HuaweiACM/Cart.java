package org.example.HuaweiACM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-23 16:59
 **/
public class Cart {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int m = scanner.nextInt();

        Goods[] goods = new Goods[m];
        for (int i = 0; i < goods.length; i++) {
            goods[i] = new Goods();
        }

        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            goods[i].v = v;
            goods[i].p = p * v;
            if (q == 0) {
                goods[i].main = true;
            } else if (goods[q - 1].a1 == -1) {
                goods[q - 1].a1 = i;
            } else {
                goods[q - 1].a2 = i;
            }
        }

        int[][] dp = new int[m + 1][N + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = dp[i - 1][j];
                if (!goods[i - 1].main) continue;
                if (j >= goods[i - 1].v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i - 1].v] + goods[i - 1].p);
                }
                if (goods[i - 1].a1 != -1 && j >= goods[i - 1].v + goods[goods[i - 1].a1].v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i - 1].v - goods[goods[i - 1].a1].v] + goods[i - 1].p + goods[goods[i - 1].a1].p);
                }
                if (goods[i - 1].a2 != -1 && j >= goods[i - 1].v + goods[goods[i - 1].a2].v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i - 1].v - goods[goods[i - 1].a2].v] + goods[i - 1].p + goods[goods[i - 1].a2].p);
                }
                if (goods[i - 1].a1 != -1 && goods[i - 1].a2 != -1 && j >= goods[i - 1].v + goods[goods[i - 1].a1].v + goods[goods[i - 1].a2].v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i - 1].v - goods[goods[i - 1].a1].v - goods[goods[i - 1].a2].v] + goods[i - 1].p + goods[goods[i - 1].a1].p + goods[goods[i - 1].a2].p);
                }
            }
        }
        System.out.println(dp[m][N]);
    }
}

class Goods {
    int v;
    int p;
    boolean main = false;

    int a1 = -1;
    int a2 = -1;
}
