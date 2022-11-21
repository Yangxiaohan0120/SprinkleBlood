package org.example.EnterpriseInterview.ShunFeng;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-31 15:34
 **/
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        int count = 0;
        int k = 1;
        int l = 1;
        while (n > 0) {
            if (n >= l) {
                n -= l;
                count += k * l;
                k ++;
                l *= 2;
            } else {
                count += k * n;
                break;
            }
        }
        System.out.println(count);
    }
}
