package org.example.AcWing.Alogrithm_Level2.I_Basic;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-10-26 19:48
 **/
public class Highdivide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int b = sc.nextInt();
        String[] res = divide(a,b);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static String[] divide(String a, int b) {
        StringBuilder sb = new StringBuilder();
        int t = 0;
        for (int i = 0; i < a.length(); i++) {
            t = t * 10 + a.charAt(i) - '0';
            sb.append(t / b);
            t %= b;
        }

        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.delete(0,1);
        }

        return new String[]{sb.toString(),String.valueOf(t)};
    }
}
