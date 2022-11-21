package org.example.HuaweiACM;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-31 13:03
 **/
public class SortNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[501];
        int n = sc.nextInt();
        int m = -1;
        for (int i = 0; i < n; i++) {
            m = sc.nextInt();
            if (arr[m] == 0) arr[i] += 1;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) System.out.println(i);
        }
    }
}
