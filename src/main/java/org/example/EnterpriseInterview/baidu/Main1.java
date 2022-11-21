package org.example.EnterpriseInterview.baidu;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-13 18:46
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int j = 0; j < n; j++) {
            arr[j] = sc.nextInt();
        }

        int count = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] <= 0) {
                i++;
            } else if (i <= n - 3) {
                if ((arr[i] + arr[i + 1] + arr[i + 2]) >= 6) {
                    count += 5;
                    arr[i] -= 1;
                    arr[i + 1] -= 2;
                    arr[i + 2] -= 3;
                } else {
                    count += arr[i];
                    arr[i] = 0;
                    i++;
                }
            } else {
                count += arr[i];
                arr[i] = 0;
                i++;
            }
        }
        System.out.println(count);
    }
}
