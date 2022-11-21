package org.example.AcWing.Alogrithm_Level2.I_Basic;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-10-26 19:48
 **/
public class HighMultiply {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int b = sc.nextInt();
        System.out.println(multiply(a,b));
    }

    public static String multiply(String a,int b){
        StringBuilder sb = new StringBuilder();
        int t = 0;
        for(int i = 1; i <= a.length() || t!= 0 ; i ++){
            if(i <= a.length()) t += (a.charAt(a.length() - i) - '0') * b;
            sb.append(t % 10);
            t /= 10;
        }

        while(sb.length() > 1 && sb.charAt(sb.length() - 1) == '0'){
            sb.delete(sb.length() -1,sb.length());
        }
        return sb.reverse().toString();
    }
}
