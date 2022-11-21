package org.example.AcWing.Alogrithm_Level2.I_Basic;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-10-26 19:48
 **/
public class Highadd {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(add(a,b));
    }

    public static String add(String a,String b){
        if(a.length() < b.length()) return add(b,a);

        StringBuilder sb = new StringBuilder();
        int t = 0;
        for(int i = 1; i <= a.length() ; i ++){
            t += a.charAt(a.length() - i) - '0';
            if(i <= b.length()) t += b.charAt(b.length() - i) - '0';
            sb.append(t % 10);
            t /= 10;
        }

        if(t > 0)sb.append(t);
        return sb.reverse().toString();

    }
}
