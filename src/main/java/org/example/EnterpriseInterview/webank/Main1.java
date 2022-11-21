package org.example.EnterpriseInterview.webank;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-13 18:46
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(find(a, b));
        }
    }

    public static int find(int a, int b) {
        int count = 0;
        if (a > b) {
            while (a != b) {
                if (a % 8 == 0 && a / 8 >= b) {
                    a /= 8;
                    count ++;
                } else if (a % 4 == 0 && a / 4 >= b) {
                    a /= 4;
                    count ++;
                } else if (a % 2 == 0 && a / 2 >= b){
                    a /= 2;
                    count ++;
                }else{
                    return -1;
                }
            }
        } else {
            while (a != b) {
                if (a * 8 <= b) {
                    a *= 8;
                    count ++;
                } else if (a * 4 <= b) {
                    a *= 4;
                    count ++;
                } else if (a * 2 <= b){
                    a *= 2;
                    count ++;
                }else {
                    return -1;
                }
            }
        }
        return count;
    }
}
