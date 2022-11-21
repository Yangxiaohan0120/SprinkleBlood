package org.example.InterView.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-28 20:18
 **/
public class Find233 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int res = find(num);
            System.out.println(res);
        }
    }

    public static int find(int mod) {
        if (mod < 233) return -1;
        long d = 23300000000000L;
        int min = Integer.MAX_VALUE;
        for (long i = d; i >= 233; i /= 10) {
            int count = 0;
            long t = i;
            int m = mod;
            while (m >= t) {
                if (m >= t) {
                    m -= t;
                    count++;
                } else {
                    t /= 10;
                }
                if (t < 233) {
                    break;
                }
            }

            if(m == 0){
                min = Math.min(min,count);
            }
        }
        return min;
    }

}
