package org.example.HuaweiACM;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-31 14:10
 **/
public class QUproblem {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            String c = sc.next();
            if (c.equals("U")) {
                int idx = sc.nextInt();
                int v = sc.nextInt();
                arr[idx] = v;
            } else if (c.equals("Q")) {
                int idx1 = sc.nextInt();
                int idx2 = sc.nextInt();
                int start = Math.min(idx2,idx1);
                int end = Math.max(idx2,idx1);
                int max = Integer.MIN_VALUE;
                for(int j = start; j <= end; j ++){
                    max = Math.max(arr[j],max);
                }
                System.out.println(max);
            }
        }
    }
}
