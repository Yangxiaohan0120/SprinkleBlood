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

            // ��ͷ�����Ѿ��ȵ�ǰֵСk��
            if (h <= t && i - k + 1 > q[h]) h++; // (��ͷ����)

            // ���ʱ��������һ��Ԫ�رȵ�ǰԪ�ش󣬳��ӣ�t--)
            while (h <= t && arr[q[t]] >= arr[i]) t--;
            q[++t] = i; // ��¼�������ꣿ

            // ���ڲ���������
            if (i >= k - 1) System.out.print(arr[q[h]] + " ");
        }

        System.out.println();

        h = 0;
        t = -1;
        for (int i = 0; i < n; i++) {

            // ��ͷ�����Ѿ��ȵ�ǰֵСk��
            if (h <= t && i - k + 1 > q[h]) h++; // (��ͷ����)

            // ���ʱ��������һ��Ԫ�رȵ�ǰԪ��С�����ӣ�t--)
            while (h <= t && arr[q[t]] <= arr[i]) t--;
            q[++t] = i; // ��¼�������ꣿ

            // ���ڲ���������
            if (i >= k - 1) System.out.print(arr[q[h]] + " ");
        }
    }
}
