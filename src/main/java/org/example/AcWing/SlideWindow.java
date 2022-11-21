package org.example.AcWing;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-31 11:00
 **/
public class SlideWindow {

    static int N = 1000010;
    static int[] arr = new int[N];
    static int[] q = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int h = 0, t = -1;
        for (int i = 0; i < n; i++) {

            // 队头坐标已经比当前值小k了
            if (h <= t && i - k + 1 > q[h]) h++; // (队头出队)

            // 入队时，如果最后一个元素比当前元素大，出队（t--)
            while (h <= t && arr[q[t]] >= arr[i]) t--;
            q[++t] = i; // 记录的是坐标？

            // 窗口不超出数组
            if (i >= k - 1) System.out.print(arr[q[h]] + " ");
        }

        System.out.println();

        h = 0;
        t = -1;
        for (int i = 0; i < n; i++) {

            // 队头坐标已经比当前值小k了
            if (h <= t && i - k + 1 > q[h]) h++; // (队头出队)

            // 入队时，如果最后一个元素比当前元素小，出队（t--)
            while (h <= t && arr[q[t]] <= arr[i]) t--;
            q[++t] = i; // 记录的是坐标？

            // 窗口不超出数组
            if (i >= k - 1) System.out.print(arr[q[h]] + " ");
        }
    }
}
