package org.example.InterView.webank;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-13 18:46
 **/
public class Main2 {

    static long result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long range = CNK(m, 3);
        // n-3���м�����Ҫ�飬range���ڵ�ֵ���ɲ��ֵ�������м���
        dfs(n - 3,  range, m,3);
        System.out.println(result % 998244353);
    }

    public static void dfs(int total, long res,int m,int n) {
        if (total == 0) {
            result += res;
            return;
        }

        // total - 1 ����һ��
        // 3 ���ظ��� * λ��
        // m-3 (���ظ��� * λ��
        dfs(total - 1,  res * 3 * n, m,n + 1);
        dfs(total - 1, res * (m-3) * (n + 1),m, n + 1);

        return;
    }

    public static long CNK(int n, int k) {
        long res = 1;
        if(k < n/2){
            k = n-k;
        }
        for (int i = n; i > k; i++) {
            res *= i;
        }
        return res;
    }
}
