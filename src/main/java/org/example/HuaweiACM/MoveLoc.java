package org.example.HuaweiACM;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-23 17:49
 **/
public class MoveLoc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0;
        String[] orders = sc.nextLine().split(";");
        int n = orders.length;
        for (int i = 0; i < n; i++) {
            String com = orders[i];
            if (com.length() > 3 || com.length() < 2) continue;
            char c = com.charAt(0);
            if (c != 'A' && c != 'W' && c != 'D' && c != 'S') continue;
            int t = 0;
            if (com.length() == 2 && Character.isDigit(com.charAt(1))) {
                t = Integer.parseInt(com.substring(1, 2));
            } else if (com.length() == 3 && Character.isDigit(com.charAt(1)) && Character.isDigit(com.charAt(2))) {
                t = Integer.parseInt(com.substring(1, 3));
            }
            if (c == 'A') {
                x -= t;
            } else if (c == 'D') {
                x += t;
            } else if (c == 'S') {
                y -= t;
            } else if (c == 'W') {
                y += t;
            }
        }
        System.out.println(x + "," + y);
    }
}
