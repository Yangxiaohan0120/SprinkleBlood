package org.example.AcWing.Alogrithm_Level2.I_Basic;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-10-26 19:48
 **/
public class Highsubtract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        if (cmp(a, b)) {
            System.out.println(subtract(a, b));
        } else {
            System.out.println("-" + subtract(b, a));
        }
    }

    public static boolean cmp(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() > b.length();
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    return a.charAt(i) - '0' > b.charAt(i) - '0';
                }
            }
        }
        return true;
    }


    public static String subtract(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int t = 0;
        for (int i = 1; i <= a.length(); i++) {
            t = a.charAt(a.length() - i) - '0' - t;
            if (i <= b.length()) t -= b.charAt(b.length() - i) - '0';
            sb.append((t + 10) % 10);
            if(t < 0)t = 1;
            else t = 0;
        }

        while(sb.length() > 1 && sb.charAt(sb.length() - 1) == '0'){
            sb.delete(sb.length() -1,sb.length());
        }

        return sb.reverse().toString();
    }
}
