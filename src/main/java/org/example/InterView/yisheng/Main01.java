package org.example.InterView.yisheng;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-10-24 16:33
 **/
public class Main01 {
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
        for(int i = a.length() - 1; i >= 0 ; i --){
            t += a.charAt(i) - '0';
            if(i < b.length()) t += b.charAt(i) - '0';
            sb.append(t % 10);
            t /= 10;
        }

        if(t > 0)sb.append(t);

        return sb.reverse().toString();


    }
}
