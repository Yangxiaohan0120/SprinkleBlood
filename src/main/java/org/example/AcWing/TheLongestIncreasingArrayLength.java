package org.example.AcWing;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-01 16:37
 **/
public class TheLongestIncreasingArrayLength {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] f = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }


        for (int i = 1; i <= n; i++) {
            f[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (a[j] < a[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(f[i], res);
        }

        System.out.println(res);

    }
}
