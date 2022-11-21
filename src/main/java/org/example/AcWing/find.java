package org.example.AcWing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-28 16:59
 **/
public class find {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int idx = sc.nextInt();
        int[] nums = new int[n];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                nums[i] += sc.nextInt();
            }
        }

        System.out.println(search(nums, idx));
    }

    public static int search(int[] nums, int idx) {
        int[] temps = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temps[i] = nums[i];
        }
        Arrays.sort(temps);
        int count = 0;
        for (int i = temps.length - 1; i >= 0; i--) {
            if (temps[i] > nums[idx]) {
                count++;
            } else {
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (idx == i) {
                count++;
                break;
            } else if (nums[i] == nums[idx]) {
                count++;
            } else continue;
        }
        return count;
    }
}
