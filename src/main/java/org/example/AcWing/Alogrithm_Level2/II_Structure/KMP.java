package org.example.AcWing.Alogrithm_Level2.II_Structure;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-10-26 20:36
 **/
public class KMP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(kmp(a,b));
    }

    public static String kmp(String a, String b){
        return "-1";
    }
}
