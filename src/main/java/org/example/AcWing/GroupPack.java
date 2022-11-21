package org.example.AcWing;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-01 15:32
 **/
public class GroupPack {

    static int N = 110;

    static int n, m;
    static int[] s;
    static int[][] v;
    static int[][] w;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = new int[n + 1];
        v = new int[n + 1][N];
        w = new int[n + 1][N];

        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
            for (int j = 1; j <= s[i]; j++) {
                v[i][j] = sc.nextInt();
                w[i][j] = sc.nextInt();
            }
        }

        int[] f = new int[m + 1];
        // ������
        for (int i = 1; i <= n; i++) {
            // ��ͬ�������
            for (int j = m; j >= 0; j--) {
                // ѡ�ĸ���Ʒ
                for (int k = 1; k <= s[i]; k++) {
                    if (v[i][k] <= j) {
                        f[j] = Math.max(f[j], f[j - v[i][k]] + w[i][k]);
                    }
                }
            }
        }

        System.out.println(f[m]);

    }
}
