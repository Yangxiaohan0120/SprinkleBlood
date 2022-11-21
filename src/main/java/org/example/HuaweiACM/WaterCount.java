package org.example.HuaweiACM;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-31 12:58
 **/
public class WaterCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int m = sc.nextInt();
            System.out.println(waterCount(m));
        }
    }

    public static int waterCount(int m) {
        int count = 0;
        while (m > 1) {
            count += m / 3;
            m = m % 3 + m / 3;
            if (m == 2) {
                count += 1;
                break;
            }
        }
        return count;
    }
}
