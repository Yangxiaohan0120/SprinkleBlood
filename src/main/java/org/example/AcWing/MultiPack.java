package org.example.AcWing;

/**
 * @author Chris Yang
 * created 2022-09-01 15:18
 **/


import java.util.Scanner;

/**
 * 将s件物品拆分，拆成log(s)件，每一个代表着不同的数量
 * 7 = 1 + 2 + 4；
 * 再套用01背包问题，每一个小件只能取一次
 */

public class MultiPack {

    static int N = 12010; // 1000 * log(2000) 上取整

    static int n, m;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] s = new int[N];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int s = sc.nextInt();
            int k = 1;
            while (k <= s) {
                cnt++;
                v[cnt] = a * k;
                w[cnt] = b * k;
                s -= k;
                k *= 2;
            }
            if (s > 0) {
                cnt++;
                v[cnt] = a * s;
                w[cnt] = b * s;
            }
        }

        n = cnt;
        int[] f = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }

        System.out.println(f[m]);

    }
}
